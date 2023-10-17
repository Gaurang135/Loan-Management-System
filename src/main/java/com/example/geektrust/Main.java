package com.example.geektrust;

import com.example.geektrust.Configs.ApplicationConfig;
import com.example.geektrust.Configs.ComandInvoker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        ApplicationConfig config = new ApplicationConfig();

//        Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream file = new FileInputStream(args[0]);
            Scanner sc = new Scanner(file); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                List<String> token = Arrays.asList(sc.nextLine().split(" "));
                ComandInvoker invoker = config.getComandInvoker();
//                System.out.println(token.get(0));
                invoker.executeCommand(token.get(0),token);


            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
            System.out.println("err");
        }
//
//        System.out.println(args[0]);



	}
}
