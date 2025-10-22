package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    public static Room room = new Room(0, 100);

    @Test
    void checkIn() {
        room.checkIn();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());

    }

    @Test
    void checkOut() {
        room.checkOut();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void cleanRoom() {
        room.cleanRoom();

        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }
}