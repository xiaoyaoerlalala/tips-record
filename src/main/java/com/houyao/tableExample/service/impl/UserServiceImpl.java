package com.houyao.tableExample.service.impl;

import com.houyao.tableExample.dao.UserDao;
import com.houyao.tableExample.pojo.User;
import com.houyao.tableExample.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;

    public User selectByPrimaryKey(){
        int id = 1;
        User user = userDao.selectByPrimaryKey(id);
       return user;
    }
}
