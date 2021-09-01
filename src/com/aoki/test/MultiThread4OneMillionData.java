package com.aoki.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 多线程写入1000万级别数据的代码
 */
public class MultiThread4OneMillionData {

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            new Thread(new MyThread()).start();
        }
    }
}

class MyThread implements Runnable {
    public void run() {
        String url = "jdbc:mysql://127.0.0.1/aoki";
        String name = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);//获取连接
            conn.setAutoCommit(false);//关闭自动提交，不然conn.commit()运行到这句会报错
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
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
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement("");//准备执行语句
            // 外层循环，总提交事务次数
            for (int i = 1; i <= 100; i++) {
                suffix = new StringBuffer();
                // 第j次提交步长
                for (int j = 1; j <= 10000; j++) {
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
                conn.commit();
                // 清空上一次添加的数据
                suffix = new StringBuffer();
            }
            // 关闭连接
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = new Date().getTime();

        LocalDateTime ldtStop = LocalDateTime.now();
        // 耗时
        System.out.println("100万条数据插入花费时间 : " + (end - begin) / 1000 + " s" + "  插入完成；从【" + ldtStart + "】开始，到【" + ldtStop + "】结束。");
    }
}
