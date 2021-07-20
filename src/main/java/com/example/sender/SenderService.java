package com.example.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SenderService {

    private final SenderDao senderDao;

    public void saveSender(Sender sender){
    senderDao.saveSender(sender);
    }
    public void update(Sender sender){
        senderDao.update(sender);
    }
    public void delete(long id){
        senderDao.delete(id);
    }
    public List<Sender> getAll(){
        return senderDao.getAll();
    }
    public Sender findById(long id){
        return senderDao.findById(id);
    }

}
