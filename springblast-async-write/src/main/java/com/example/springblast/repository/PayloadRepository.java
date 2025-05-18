package com.example.springblast.repository;

import com.example.springblast.entity.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayloadRepository extends JpaRepository<Payload, Long> {
}
