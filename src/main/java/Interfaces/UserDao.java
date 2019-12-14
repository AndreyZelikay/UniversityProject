package Interfaces;

import Models.User;

import javax.persistence.NoResultException;

public interface UserDao {

    User findById(int id);
    void save(User user);
    void delete(User user);
    void update(User user);
    User findByNameAndPassword(String name, String password) throws NoResultException;
    User findByName(String name) throws NoResultException;

}
