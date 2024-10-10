package com.no_country.demo.entities.enums;

public enum Qualification {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);

    private  int value;

    Qualification(int value) {
        this.value = value;
    }

    public int getValor() {
        return value;
    }
}
