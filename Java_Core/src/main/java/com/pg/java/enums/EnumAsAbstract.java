package com.pg.java.enums;

public class EnumAsAbstract {

}

enum Currency {
    PENNY(1) {
        @Override
        public String color() {
            return "copper";
        }
    };
    private int value;
    public abstract String color();
    private Currency(int value) {
        this.value = value;}
}     
