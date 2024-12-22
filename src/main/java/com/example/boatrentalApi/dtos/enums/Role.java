package com.example.boatrentalApi.dtos.enums;

public enum Role {
    ADMIN (1),
    CLIENT (2),
    WORKER (3);

    private int value;

    Role(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}


