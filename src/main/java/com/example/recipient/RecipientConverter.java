package com.example.recipient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class RecipientConverter implements Converter<String, Recipient> {

    @Autowired
    private RecipientService recipientService;

    @Override
    public Recipient convert(String s) {
        return recipientService.findById((long) Integer.parseInt(s));
    }
}
