package kz.ektu.korgan.sakauov.lab5;
import java.util.ArrayList;
import java.util.List;
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
class Student {
    String name;
    int age;
    public Student(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Ошибка: студенту должно быть 18 лет или больше!");
        }
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " (" + age + " лет)";
    }
}
class School {
    List<Student> students = new ArrayList<>();
    public void addStudent(String name, int age) {
        try {
            Student s = new Student(name, age);
            students.add(s);
            System.out.println("Студент добавлен:" + s);
        } catch (InvalidAgeException e) {
            System.out.println("Невозможно добавить:" + e.getMessage());
        }
    }
}
public class srs61 {
    public static void main(String[] args) {
        School school = new School();
        school.addStudent("Алия", 19);
        school.addStudent("Кайрат", 16);
        school.addStudent("Жанна", 21);
    }
}
