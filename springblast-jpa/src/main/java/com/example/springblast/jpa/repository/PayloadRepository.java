package com.example.springblast.jpa.repository;

import com.example.springblast.jpa.entity.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayloadRepository extends JpaRepository<Payload, Long> {
}
