package com.ljq.test;


class FinalFieldExample {
    /*
    //类里面的final字段可以不赋值，但是必须在其构造方法里面赋值,并且是所有的构造方法
    //如果在定义时候赋值，则其在构造函数里面的赋值会报错
    *
    *
    * */
    final int x;
    int y;
    static FinalFieldExample f;

    public FinalFieldExample() {
        x = 3;
        // y = 4;
    }

    public FinalFieldExample(int a) {
        x = 3;
        // y = 4;
    }

    static void writer() {
        //在多线程环境下  f 可能已经有值了，但是对象还没有构造好，但是final对象肯定初始化完全了，这符合final的语义
        f = new FinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;
            int j = f.y;
        }
    }
}