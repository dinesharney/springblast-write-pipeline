package com.example.shared;

import lombok.Data;

@Data
public class WriteEvent {
    private String id;
    private String data;
    private long timestamp;
}
