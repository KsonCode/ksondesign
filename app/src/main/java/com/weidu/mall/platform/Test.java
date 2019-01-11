package com.weidu.mall.platform;

public class Test {
    public static void main(String[] a){

        String str = "null";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("=========");
            }
        });
        thread.start();

        try {
            thread.join();//加入
            thread.yield();//让出执行权
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("========");



    }
}
