package com.aoki.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 2分13秒插进数据库20000000条数据。稳定性好！
 */
public class JavaTest5 {
    public static void main(String[] args) {


        String url = "jdbc:mysql://127.0.0.1/aoki";
        String name = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "123456";
        //Connection conn = null;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100));
        for (int i = 0; i < 20; i++) {
//            final int taskIndex = i;
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
//                    System.out.println(taskIndex);
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    String url = "jdbc:mysql://127.0.0.1/aoki";
//                    String name = "com.mysql.jdbc.Driver";
//                    String user = "root";
//                    String password = "123456";
//                    Connection conn = null;
//
//                    try {
//                        Class.forName(name);
//                        conn = DriverManager.getConnection(url, user, password);//获取连接
//                        conn.setAutoCommit(false);//关闭自动提交，不然conn.commit()运行到这句会报错
//                    } catch (ClassNotFoundException e1) {
//                        e1.printStackTrace();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }

                    ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
                        public Connection initialValue() {
                            Connection conn2 = null;
                            try {
                                Class.forName(name);
                                conn2 = DriverManager.getConnection(url, user, password);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            return conn2;
                        }
                    };

                    Connection connection = connectionHolder.get();

                    try {
                        connection.setAutoCommit(false);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    // 开始时间
                    Long begin = new Date().getTime();

                    LocalDateTime ldtStart = LocalDateTime.now();
                    // sql前缀
                    String prefix = "INSERT INTO test_blog (id,author,content,create_time,title,update_time) VALUES ";
                    try {
                        // 保存sql后缀
                        StringBuffer suffix = new StringBuffer();
                        // 设置事务为非自动提交
                        //conn.setAutoCommit(false);
                        // 比起st，pst会更好些
                        PreparedStatement pst = (PreparedStatement) connection.prepareStatement("");//准备执行语句
                        // 外层循环，总提交事务次数
                        for (int i = 1; i <= 10; i++) {
                            suffix = new StringBuffer();
                            // 第j次提交步长
                            for (int j = 1; j <= 100000; j++) {
                                // 构建SQL后缀
                                suffix.append("('" + i * j + "','八百屋'" + ",'一部关于京都市的传说'" + ",'2016-08-16 14:43:26'" + ",'www.bbb.com'" + ",'2016-08-16 14:43:26'" + "),");
                            }
                            // 构建完整SQL
                            String sql = prefix + suffix.substring(0, suffix.length() - 1);
                            // 添加执行SQL
                            pst.addBatch(sql);
                            // 执行操作
                            pst.executeBatch();
                            // 提交事务
                            connection.commit();
                            // 清空上一次添加的数据
                            suffix = new StringBuffer();
                        }

                        pst.close();
//                        connection.close();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    // 结束时间
                    Long end = new Date().getTime();

                    LocalDateTime ldtStop = LocalDateTime.now();
                    // 耗时
                    System.out.println("100万条数据插入花费时间 : " + (end - begin) / 1000 + " s" + "  插入完成；从【" + ldtStart + "】开始，到【" + ldtStop + "】结束。");
                }
            });
        }

    }
}
