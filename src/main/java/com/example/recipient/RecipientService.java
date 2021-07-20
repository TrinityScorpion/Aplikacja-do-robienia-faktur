package com.example.recipient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RecipientService {

    private final RecipientDao recipientDao;

    public void saveRecipient(Recipient recipient){
        recipientDao.saveRecipient(recipient);
    }

    public void update(Recipient recipient){
        recipientDao.update(recipient);
    }

    public void delete(Long id){
        recipientDao.delete(id);
    }

    public List<Recipient> getAll(){
        return recipientDao.getAll();
    }

    public Recipient findById(Long id){
        return recipientDao.findById(id);
    }
}
