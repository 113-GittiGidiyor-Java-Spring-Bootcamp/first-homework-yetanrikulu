package controller;

import model.Student;
import service.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService = new StudentService();

    public List<Student> findAll() {
        return studentService.findAll();
    }

    public void changeName(Student student, String name) {
        studentService.changeName(student, name);
    }

    public void save(Student student) {
        studentService.save(student);
    }

    public void delete(Student student) {
        studentService.delete(student);
    }

}
