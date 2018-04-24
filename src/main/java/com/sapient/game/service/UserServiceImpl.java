package com.sapient.game.service;



import com.sapient.game.model.User;

import java.util.List;

/**
 * Created by Sourabh on 4/23/2018.
 */
public class UserServiceImpl implements IUserService {
    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User findBySSO(String sso) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserBySSO(String sso) {

    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        return false;
    }
}
