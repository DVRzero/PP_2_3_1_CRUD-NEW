package web.dao;

import org.springframework.stereotype.Repository;

import web.model.User;

@Repository
public class UserDaoImpl implements UserDao {



    @Override
    public String getUserName() {
        User user = new User("FirstName", "SecondName", "email@mail.ru");
        return user.getFirstName();
    }
}
