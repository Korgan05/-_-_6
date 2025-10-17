package kz.ektu.korgan.sakauov.lab5;
import java.util.HashMap;
import java.util.Map;
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
class LowGradeException extends Exception {
    public LowGradeException(String message) {
        super(message);
    }
}
public class srs62 {
    public static void findGrade(Map<String, Integer> grades, String student)
            throws StudentNotFoundException, LowGradeException {
        if (!grades.containsKey(student)) {
            throw new StudentNotFoundException("Студент " + student + " не найден!");
        }
        int grade = grades.get(student);
        if (grade < 50) {
            throw new LowGradeException("У студента " + student + " низкая оценка: " + grade);
        }
        System.out.println(student + " успешно сдал с оценкой " + grade);
    }
    public static void main(String[] args) {
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Алия", 90);
        grades.put("Кайрат", 40);
        try {
            findGrade(grades, "Алия");
            findGrade(grades, "Кайрат");
            findGrade(grades, "Жанна");
        }
        catch (StudentNotFoundException e) {
            System.out.println("Ошибка:" + e.getMessage());
        }
        catch (LowGradeException e) {
            System.out.println("Низкий балл:" + e.getMessage());
        }
        finally {
            System.out.println("Проверка завершена.");
        }
    }
}
