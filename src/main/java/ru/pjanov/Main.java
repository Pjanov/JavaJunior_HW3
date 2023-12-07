package ru.pjanov;

/*
 * - Разработайте класс Student с полями:
 *   String name, int age, transient double GPA (средний балл).
 * - Обеспечьте поддержку сериализации для этого класса.
 * - Создайте объект класса Student и инициализируйте его данными.
 * - Сериализуйте этот объект в файл.
 * - Десериализуйте объект обратно в программу из файла.
 * - Выведите все поля объекта, включая GPA, и обсудите, почему значение GPA
 *   не было сохранено/восстановлено.
 */
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Иванов", 20, 4.5);

        student.serializeStudent(student, "student.bin");
        Student deserializedStudent = student.deserializeStudent("student.bin");
        student.printStudentDetails(deserializedStudent);

        /*
         * Значение GPA не было сохранено и восстановлено, потому что оно было объявлено как transient,
         * которое используется для того, чтобы исключить поле из процесса сериализации.
         * В данном случае мы используем transient для GPA, предполагая,
         * что средний балл может быть вычисляемым или изменяемым свойством,
         * которое не требуется сохранять.
         */
    }
}
