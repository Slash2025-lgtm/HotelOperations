package com.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    @Test
    void checkIn() {
        Room room = new Room(0, 100);

        room.checkIn();

        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());

    }

    @Test
    void checkOut() {
        Room room = new Room(0, 100);

        room.checkOut();

        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    void cleanRoom() {
        Room room = new Room(0, 100);

        room.cleanRoom();

        assertFalse(room.isDirty());
    }
}