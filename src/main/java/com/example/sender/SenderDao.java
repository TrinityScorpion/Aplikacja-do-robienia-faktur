package com.example.sender;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SenderDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveSender(Sender sender){
        entityManager.persist(sender);
    }
    public Sender findById(long id){
        return entityManager.find(Sender.class, id);
    }
    public List<Sender> getAll(){
        return entityManager.createQuery("SELECT s FROM Sender s").getResultList();
    }
    public void update(Sender sender){
        entityManager.merge(sender);
    }
    public void delete(Long id){
        Sender sender = findById(id);
        entityManager.remove(entityManager.contains(sender) ? sender:entityManager.merge(sender));
    }

}
