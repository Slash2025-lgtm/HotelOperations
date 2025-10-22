package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private boolean occupied, dirty;
    private double price;

    public Room(int numberOfBeds, double price) {
        this.numberOfBeds = numberOfBeds;
        this.occupied = false;
        this.dirty = false;
        this.price = price;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean isAvailable() {
        return (!this.dirty && !this.occupied);
    }

    public void checkIn() {
        this.occupied = true;
        this.dirty = true;
    }

    public void checkOut() {
        this.occupied = false;
    }

    public void cleanRoom() {
        this.dirty = false;
    }
}