package com.example.agenda.enums;

public enum Horario {

    H_8_00("08:00"),
    H_9_00("09:00"),
    H_10_00("10:00"),
    H_11_00("11:00"),
    H_12_00("12:00"),
    H_13_00("13:00"),
    H_14_00("14:00"),
    H_15_00("15:00"),
    H_16_00("16:00"),
    H_17_00("17:00");

    private String time;

    Horario(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }
}
