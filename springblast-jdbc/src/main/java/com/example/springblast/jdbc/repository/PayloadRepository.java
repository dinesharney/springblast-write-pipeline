package com.example.springblast.jdbc.repository;

import com.example.springblast.jdbc.entity.Payload;
import org.springframework.data.repository.CrudRepository;

public interface PayloadRepository extends CrudRepository<Payload, Long> {
}
