package com.example.demo.Entity;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TMessage {

    private int id;
    private String content;
    private int roomId;
    private int userId;
    private byte[] image;

    @DateTimeFormat(pattern = "yyyy_MM_dd HH:mm:ss")
    private LocalDateTime createdAt;

    @DateTimeFormat(pattern = "yyyy_MM_dd HH:mm:ss")
    private LocalDateTime updatedAt;
}