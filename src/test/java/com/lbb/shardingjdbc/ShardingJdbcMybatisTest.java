package com.lbb.shardingjdbc;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import com.lbb.shardingjdbc.entity.Student;
import com.lbb.shardingjdbc.entity.User;
import com.lbb.shardingjdbc.service.StudentService;
import com.lbb.shardingjdbc.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/spring/spring-database.xml",
        "classpath*:config/spring/spring-sharding.xml" })
public class ShardingJdbcMybatisTest {

    @Resource
    public UserService userService;
    
    @Resource
    public StudentService studentService;

    @Test
    public void testUserInsert() {
        Date date = new Date();
        User u = new User();
        u.setId(date.getTime());
        u.setUserId(15);
        u.setAge(25);
        u.setName("war3");
        Assert.assertEquals(userService.insert(u), true);
    }
    
    @Test
    public void testStudentInsert() {
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        Assert.assertEquals(studentService.insert(student), true);
    }

    @Test
    public void testFindAll(){
        List<User> users = userService.findAll();
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }
    
    @Test
    public void testSQLIN(){
        List<User> users = userService.findByUserIds(Arrays.asList(16));
        if(null != users && !users.isEmpty()){
            for(User u :users){
                System.out.println(u);
            }
        }
    }
    
    @Test
    public void testTransactionTestSucess(){
        userService.transactionTestSucess();
    }
    
    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException{
        userService.transactionTestFailure();
    }
    
    
}
