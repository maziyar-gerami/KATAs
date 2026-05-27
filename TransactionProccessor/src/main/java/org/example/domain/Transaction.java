package org.example.domain;

import lombok.Getter;

public record Transaction(String id, double amount, Category category, Status status) {
}