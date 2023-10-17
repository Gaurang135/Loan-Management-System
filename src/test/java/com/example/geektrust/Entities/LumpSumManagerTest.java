package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class LumpSumManagerTest {

    private LumpSumManager lumpSumManager;

    @BeforeEach
    void setUp() {
        lumpSumManager = new LumpSumManager();
    }

    @Test
    void addLumpsum() {
        // Arrange
        Lumpsum lumpsum = new Lumpsum(1000, 1);

        // Act
        lumpSumManager.addLumpsum(lumpsum);

        // Assert
        List<Lumpsum> lumpsumPayments = lumpSumManager.getLumpSumBeforeEmi(2);
        assertEquals(1, lumpsumPayments.size());
        assertEquals(lumpsum, lumpsumPayments.get(0));
    }

    @Test
    void getLumpSumBeforeEmi() {
        // Arrange
        Lumpsum lumpsum1 = new Lumpsum(500, 2);
        Lumpsum lumpsum2 = new Lumpsum(800, 3);

        // Act
        lumpSumManager.addLumpsum(lumpsum1);
        lumpSumManager.addLumpsum(lumpsum2);

        // Assert
        List<Lumpsum> lumpsumPayments = lumpSumManager.getLumpSumBeforeEmi(3);
        assertEquals(2, lumpsumPayments.size());
        assertTrue(lumpsumPayments.contains(lumpsum1));
        assertTrue(lumpsumPayments.contains(lumpsum2));
    }

    @Test
    void isLumpsumBeforeEmi() {
        // Arrange
        Lumpsum lumpsum1 = new Lumpsum(500, 2);

        // Act
        lumpSumManager.addLumpsum(lumpsum1);

        // Assert
        assertTrue(lumpSumManager.isLumpsumBeforeEmi(2));

    }
}
