package com.ljq.test;


public class sds {
    public enum Boss {

        INSTANCE;

        Boss() {
            System.out.println("初始化。。。");
        }

        private String name;

        public void doSomeThing() {
            System.out.println(name + " is doing something now...");
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static void main(String[] a) {
        new sds().testSingleton();
    }


    public void testSingleton() {

        System.out.println("111111111111");
        Boss b1 = Boss.INSTANCE;
        System.out.println("aaaaaaaaaaaa");
        b1.setName("张三");
        System.out.println("bbbbbbbbbbbb");

        b1.doSomeThing();//张三 is doing something now...

        Boss b2 = Boss.INSTANCE;
        b2.doSomeThing();//张三 is doing something now...

        System.out.println(b1.equals(b2));//true

    }

}
