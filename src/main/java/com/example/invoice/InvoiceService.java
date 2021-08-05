package com.example.invoice;

import com.example.user.User;
import com.example.user.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceDao invoiceDao;
    private final UserDao userDao;

    public void createInvoice(Invoice invoice){
        invoiceDao.saveInvoice(invoice);
    }

    public Invoice findById(Long id){
        return invoiceDao.findById(id);
    }

    public List<Invoice> getAll(){
        return invoiceDao.getAll();
    }
    public List<User> getAllUsers(){
        return userDao.getAll();
    }


    public void update(Invoice invoice){
        invoiceDao.update(invoice);
    }
    public void delete(Long id){
        invoiceDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User findByUserId(long id) {
        return userDao.findById(id);
    }


}
