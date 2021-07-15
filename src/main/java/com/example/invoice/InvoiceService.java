package com.example.invoice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceDao invoiceDao;

    public void createInvoice(Invoice invoice){
        invoiceDao.saveInvoice(invoice);
    }

    public Invoice findById(Long id){
        return invoiceDao.findById(id);
    }

    public List<Invoice> getAll(){
        return invoiceDao.getAll();
    }

    public void update(Invoice invoice){
        invoiceDao.update(invoice);
    }
    public void delete(Long id){
        invoiceDao.delete(id);
    }



}
