package com.test.bean;

import org.apache.ibatis.jdbc.SQL;


/**
 * Created by Administrator on 2015/2/12.
 */
public class Test {
    public static void main(String [] a){
        System.out.print(new SQL().SELECT("a , b , b ").FROM("TABLE").WHERE("A =  A AND B=B").toString());
    }
}
