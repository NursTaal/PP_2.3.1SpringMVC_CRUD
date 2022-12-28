package web.DAO;


import org.springframework.stereotype.Service;


import web.model.User;

import javax.persistence.*;
import java.util.List;

@Service
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<User> listUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User user) {
         User user1 = entityManager.find(User.class,id);
         user1.setName(user.getName());
         user1.setSurName(user.getSurName());
        entityManager.merge(user1);
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }

}
