package ru.pjanov;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Сериализация и десериализация объекта Student в JSON:
 */
public class JsonSerializationExample {

    public static String FILE_NAME = "student.json";

    public static void main(String[] args) {

        Student student = new Student("Иванов", 20, 5);

        serializeObjectStudent(FILE_NAME, student);
        System.out.println(deserializeObjectStudent(FILE_NAME));
    }

    public static void serializeObjectStudent(String fileName, Student student) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(fileName), student);
            System.out.println("Объект успешно сериализован в файл student.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student deserializeObjectStudent(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fileName), Student.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
