package web.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public String showUserName() {
        return userDao.getUserName();
    }
}