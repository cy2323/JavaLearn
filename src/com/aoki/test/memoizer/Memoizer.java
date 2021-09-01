package com.aoki.test.memoizer;

import com.aoki.test.memoizer.interfaces.Computable;

import java.util.concurrent.*;

public class Memoizer<A,V> implements Computable<A,V> {

    private ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();

    private Computable<A,V> c;

    /**
     * 有参构造方法为局部变量赋初值
     * @param c
     */
    public Memoizer(Computable<A,V> c) {
        this.c = c;
    }

    @Override
    public V computer(A arg) {
        while(true){
            Future<V> f = cache.get(arg);
            if(f ==null){
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.computer(arg);
                    }
                };

                FutureTask<V> ft = new FutureTask<>(eval);
                f = cache.putIfAbsent(arg,ft);
                if(f == null){
                    f = ft;
                    ft.run();
                }
            }

            try {
                return f.get();
            } catch (CancellationException e) {
                cache.remove(arg,f);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
