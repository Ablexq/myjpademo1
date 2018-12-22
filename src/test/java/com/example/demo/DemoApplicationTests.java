package com.example.demo;

import com.example.demo.dao.TestDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.TestEntity;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Autowired
    TestDao testDao;

    @Test
    public void test1() {
        List<TestEntity> all = testDao.findAll();
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i).toString());
        }
    }

    @Autowired
    UserDao userDao;

    @Test
    public void test2() {
        List<User> userList = userDao.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void test3() {
        int page =3, size = 3;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> userPage = userDao.findAll(pageable);

        System.out.println("getNumber==" + userPage.getNumber());  //当前页页码【0，list.size-1】
        System.out.println("getNumberOfElements===" + userPage.getNumberOfElements());  //当前页元素数量
        System.out.println("getSize===" + userPage.getSize());   //每页数量size
        System.out.println("getTotalElements===" + userPage.getTotalElements());  //总数量
        System.out.println("getTotalPages====" + userPage.getTotalPages());    //总页数

        List<User> content = userPage.getContent();
        for (int i = 0; i < content.size(); i++) {
            System.out.println(content.get(i).toString());
        }
    }
}

