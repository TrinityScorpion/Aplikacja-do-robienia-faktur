package com.example.invoice;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InvoiceDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveInvoice(Invoice invoice) {
        entityManager.persist(invoice);
    }

    public Invoice findById(long id) {
        return entityManager.find(Invoice.class, id);
    }

    public List<Invoice> getAll() {
        return entityManager.createQuery("SELECT i FROM Invoice i").getResultList();
    }

    public void update(Invoice invoice){
        entityManager.merge(invoice);
    }

    public void delete(Long id){
        Invoice invoice = findById(id);
        entityManager.remove(entityManager.contains(invoice) ? invoice : entityManager.merge(invoice));
    }

}
