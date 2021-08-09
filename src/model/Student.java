package model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student extends Person {
    private LocalDate birthDate;
    private String gender;
    @ManyToMany
    private List<Course> courseList = new ArrayList<>();

    public Student(String name, String address,LocalDate birthDate, String gender){
        super(name,address);
        this.birthDate = birthDate;
        this.gender = gender;
        this.courseList = courseList;
    }

    public Student(LocalDate birthDate, String gender, List<Course> courseList) {
        this.birthDate = birthDate;
        this.gender = gender;
        this.courseList = courseList;
    }

    public Student() {
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
