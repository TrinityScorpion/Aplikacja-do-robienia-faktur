package com.example.sender;

import org.hibernate.engine.jdbc.connections.internal.ConnectionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class SenderConverter implements Converter<String, Sender> {

    @Autowired
    private SenderService senderService;


    @Override
    public Sender convert(String s) {
        return senderService.findById(Integer.parseInt(s));
    }
}
