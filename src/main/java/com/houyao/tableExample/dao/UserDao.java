package com.houyao.tableExample.dao;

import com.houyao.tableExample.pojo.User;

import java.util.List;


public interface UserDao {
    User selectByPrimaryKey(Integer id);
}
