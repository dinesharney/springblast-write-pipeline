package com.example.springblast.jpa.service;

import com.example.springblast.jpa.entity.Payload;
import com.example.springblast.jpa.repository.PayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WriterService {

    @Autowired
    PayloadRepository repository;

    public Payload write(Payload payload) {
        return repository.save(payload);
    }

}
