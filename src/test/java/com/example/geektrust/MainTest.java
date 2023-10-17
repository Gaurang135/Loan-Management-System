package com.example.geektrust;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@DisplayName("MainTest")
public class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test")
    void main() {


        Main.main(new String[]{"sample_input/input1.txt"});

        String expectedOutput = "IDIDI Dale 1326 9" + System.lineSeparator() +
                "IDIDI Dale 3652 4" + System.lineSeparator() +
                "UON Shelly 15856 3" + System.lineSeparator() +
                "MBI Harry 9044 10";
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}