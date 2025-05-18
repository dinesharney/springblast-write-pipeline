package com.example.consumer.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Data
@Table("payload")
public class Payload {
    @Id
    private Long id;
    private String data;
    private Instant createdAt;
}