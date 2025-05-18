package com.example.springblast.async.repository;

import com.example.springblast.async.entity.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayloadRepository extends JpaRepository<Payload, Long> {
}
