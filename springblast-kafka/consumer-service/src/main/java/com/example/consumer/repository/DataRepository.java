package com.example.consumer.repository;

import com.example.consumer.model.Payload;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Payload, Long> {}