package com.example.springblast.r2dbc.util;

import jakarta.annotation.PostConstruct;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class SchemaLoader {

    private final DatabaseClient client;

    public SchemaLoader(DatabaseClient client) {
        this.client = client;
    }

    //@PostConstruct
    public void init() throws IOException {
        String schema = Files.readString(Path.of("src/main/resources/schema.sql"));
        client.sql(schema).then().subscribe();
    }
}

