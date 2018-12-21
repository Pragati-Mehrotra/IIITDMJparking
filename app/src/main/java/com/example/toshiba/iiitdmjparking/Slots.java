package com.example.toshiba.iiitdmjparking;

public class Slots {

    private int sensor1value, sensor2value, sensor3value;

    public Slots(int sensor1value, int sensor2value, int sensor3value) {
        this.sensor1value = sensor1value;
        this.sensor2value = sensor2value;
        this.sensor3value = sensor3value;
    }

    public Slots(){

    }

    public int getSensor1value() {
        return sensor1value;
    }

    public void setSensor1value(int sensor1value) {
        this.sensor1value = sensor1value;
    }

    public int getSensor2value() {
        return sensor2value;
    }

    public void setSensor2value(int sensor2value) {
        this.sensor2value = sensor2value;
    }

    public int getSensor3value() {
        return sensor3value;
    }

    public void setSensor3value(int sensor3value) {
        this.sensor3value = sensor3value;
    }
}
