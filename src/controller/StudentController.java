package controller;

import model.Student;
import service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public List<Student> findAll(){
        return studentService.findAll();
    }

    public Student findById(int id){
        return studentService.findById(id);
    }

    public void save(Student student){
        studentService.save(student);
    }

    public void delete(Student student){
        studentService.delete(student);
    }

}
