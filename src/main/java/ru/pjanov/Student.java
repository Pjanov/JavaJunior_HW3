package ru.pjanov;

import java.io.*;

/**
 * Класс Студент
 */
public class Student implements Serializable {

    // region Поля

    private String name;
    private int age;
    private transient double GPA;

    // endregion

    // region Конструкторы

    /**
     * Конструктор класса Student
     *
     * @param name Имя студента
     * @param age  Возраст студента
     * @param GPA  Средний балл студента
     */
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    // endregion

    // region Методы

    /**
     * Метод для сериализации объекта Student в файл.
     *
     * @param student  Объект Student, который нужно сериализовать
     * @param fileName Имя файла, в который будет сохранен сериализованный объект
     */
    public void serializeStudent(Student student, String fileName) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);
            System.out.println("Объект успешно сериализован в файл " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для десериализации объекта Student из файла.
     *
     * @param fileName Имя файла, из которого нужно десериализовать объект Student
     * @return Возвращает десериализованный объект Student
     */
    public Student deserializeStudent(String fileName) {
        Student student = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            student = (Student) in.readObject();
            System.out.println("Объект успешно десериализован из файла " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    /**
     * Метод для вывода всех полей объекта Student.
     *
     * @param student Объект Student, поля которого нужно вывести
     */
    public void printStudentDetails(Student student) {
        System.out.println("Имя студента: " + student.name);
        System.out.println("Возраст студента: " + student.age);
        System.out.println("Средний балл студента: " + student.GPA);
    }

    // endregion
}
