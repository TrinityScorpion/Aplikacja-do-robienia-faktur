package com.example.user;

import com.example.invoice.Invoice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAll(){
        return entityManager.createQuery("SELECT u FROM User u").getResultList();
    }

    public User findById(long id){
        return entityManager.find(User.class, id);
    }

    public void update(User user){
        entityManager.merge(user);
    }
    public void delete(long id){
        User user = findById(id);
        entityManager.remove(entityManager.contains(user) ? user:entityManager.merge(user));
    }
}
