package com.sapient.game.dao;

import com.sapient.game.model.User;

import java.util.List;

/**
 * Created by Sourabh on 4/23/2018.
 */
public interface IUserDao {

    User findById(int id);

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    List<User> findAllUsers();
}
