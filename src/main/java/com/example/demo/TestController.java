package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class TestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUser() {
        return userDao.findAll();
    }

}
