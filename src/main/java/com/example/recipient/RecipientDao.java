package com.example.recipient;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RecipientDao {

    @PersistenceContext
    EntityManager entityManager;

    public void saveRecipient(Recipient recipient){
        entityManager.persist(recipient);
    }

    public Recipient findById(long id){
        return entityManager.find(Recipient.class, id);
    }

    public List<Recipient> getAll(){
        return entityManager.createQuery("SELECT r from Recipient r").getResultList();
    }

    public void update(Recipient recipient){
        entityManager.merge(recipient);
    }

    public void delete(Long id){
        Recipient recipient = findById(id);
        entityManager.remove(entityManager.contains(recipient) ? recipient : entityManager.merge(recipient));
    }


}
