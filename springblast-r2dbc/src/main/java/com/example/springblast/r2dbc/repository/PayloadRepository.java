package com.example.springblast.r2dbc.repository;

import com.example.springblast.r2dbc.entity.Payload;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PayloadRepository extends ReactiveCrudRepository<Payload, Long> {
}
