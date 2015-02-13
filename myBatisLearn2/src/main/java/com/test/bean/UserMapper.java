package com.test.bean;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    //****** 查询用户  ******
    public User selectUser(String id);

    @Select("select * from user where uid = #{id}")
    public User selectUser2(String id);
    @Select("select * from user where user_name like \"%\"#{name}\"%\"")
    public List<User> fuzzyQuery(String name);

    //****** 查询所有用户  ******
    public List<User> selectAll();

    //****** 插入用户  ******
    public int insertUser(User user);

    @Insert("insert into user(account,user_name,created_date) values(#{account},#{userName},now())")
    public int insertUser2(User user);

    //******* 修改用户  *******

    @Update("update user set user_name=#{userName} where uid=#{uid}")
    public int updateUser(User user);


    //******* 删除  *******
    @Update("delete from user where uid = #{id}")
    public int deleteUser(int id);


    //******* 批量插入  *******
    public int insertBatch(List list);

    public List<User> selectUserTestIf(User user ) ;


}
