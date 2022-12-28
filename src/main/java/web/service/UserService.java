package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    User show(int id);
    List<User> listUser();
    void save(User user);
    void update(int id, User user);
    void delete(int id);

}
