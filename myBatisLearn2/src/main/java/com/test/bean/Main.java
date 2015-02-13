package com.test.bean;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Main {
    private SqlSession session = null;
    private UserMapper userMapper = null;
    private final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        session = initSession();
        userMapper = session.getMapper(UserMapper.class);


        testSelectUserIf();


        //testDelete();
        //testUpdate();
        //testInsert();
        // testSelect();
        if(null != session){
            session.commit();
            session.close();
        }
    }

    private  void  testBuildSql(){
        System.out.print(new SQL().SELECT("a , b , b ").FROM("TABLE").WHERE("A =  A AND B=B").toString()
        );
    }

    private void testDelete(){
        System.out.println(userMapper.deleteUser(10000));
    }

    private void testUpdate(){
        User user = new User();
        user.setUid(10000);
        user.setUserName("修改");
        System.out.println(userMapper.updateUser(user));
    }

    private void testInsert(){
        User user = new User();
        user.setUid(10000);
        user.setAccount("aaaaa");
        user.setUserName("展示");
        System.out.println(user.toString());

        System.out.println("before :"+user.getUid());
        userMapper.insertUser(user) ;
        System.out.println("after :" +user.getUid());


        System.out.println(userMapper.insertUser(user));
        System.out.println("after :");

        //批量插入
        User u1 = new User();
        u1.setAccount("user1");
        u1.setUserName("user1");
        User u2 = new User();
        u2.setAccount("user3");
        u2.setUserName("user3");
        List<User> l = new ArrayList<User>();
        l.add(u1);
        l.add(u2);
        userMapper.insertBatch(l);
    }

    private  void testSelectUserIf(){

        User  u = new  User();
        u.setUid(1);
        userMapper.selectUserTestIf(u) ;
        u.setAccount("1");
        userMapper.selectUserTestIf(u) ;

    }

    private void testSelect(){
//        User t =    session.selectOne("selectUser","1003") ;

//      System.out.println("session.selectOne: "+t.toString());


        User user = userMapper.selectUser2("1003");
        System.out.println(user.toString());
        user = userMapper.selectUser2("10000");
        System.out.println(user.toString());

       /* List<User> list = userMapper.selectAll();
        for(User u : list){
            System.out.println(u.toString());
        }*/

        List<User> list2 = userMapper.fuzzyQuery("展");
        for(User u : list2){
            System.out.println(u.toString());
        }
    }

    private SqlSession initSession(){
        //获取配置文件的输入流
        InputStream is;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取我们的SqlSessionFactory（相当于Hibernate的SessionFactory）；SqlSessionFactoryBuilder有点类似于Hibernate的Configuration。
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //获取一个Session
            return sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
