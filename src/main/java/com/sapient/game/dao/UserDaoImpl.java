package com.sapient.game.dao;

import com.sapient.game.model.User;

import java.util.List;

/**
 * Created by Sourabh on 4/23/2018.
 */
public class UserDaoImpl extends AbstractDao implements IUserDao {


    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User findBySSO(String sso) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void deleteBySSO(String sso) {

    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}
