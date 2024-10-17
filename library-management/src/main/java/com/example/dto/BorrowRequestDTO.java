package com.example.dto;

import lombok.Data;

@Data
public class BorrowRequestDTO {
    private Long bookId;
    private Long borrowerId;
}