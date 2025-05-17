package com.example.springblast.jdbc.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.time.Instant;

@Table("payload")
@Data
public class Payload {
    @Id
    private Long id;
    private String data;
    private Instant createdAt = Instant.now();
}
