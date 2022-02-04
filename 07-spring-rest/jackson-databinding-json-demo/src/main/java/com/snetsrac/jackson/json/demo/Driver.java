package com.snetsrac.jackson.json.demo;

import java.io.File;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {
    public static void main(String[] args) {
        try {

            // Create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // Read json file and map to Java POJO
            Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            // Print properties
            System.out.println("Id: " + student.getId());
            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());
            System.out.println("Active: " + student.isActive());
            System.out.println("Address: " + student.getAddress());
            System.out.println("Languages: " + Arrays.toString(student.getLanguages()));
           

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
