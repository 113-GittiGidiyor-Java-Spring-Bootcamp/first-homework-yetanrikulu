package client;

import controller.StudentController;
import model.*;
import util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class SchoolManagementApiClient {
    public static void main(String[] args) throws InterruptedException {
        if (checkTestData() == 0) {
            saveTestData();
        }

        // CRUD Operations
        StudentController studentController = new StudentController();

        //Create
        Student student = new Student("Cemile Yılmaz Öğrenci", "Cemile adres", LocalDate.of(2001, Month.SEPTEMBER, 3), "Female");
        studentController.save(student);

        //Read
        System.out.println("\n-- After Creating Student --");
        List<Student> studentList = studentController.findAll();
        studentList.stream().forEach(s -> System.out.println(s.getName()));

        //Update
        studentController.changeName(student, "Selin Toprak Öğrenci");
        System.out.println("\n-- After Updating Student Name --");
        studentList = studentController.findAll();
        studentList.stream().forEach(s -> System.out.println(s.getName()));

        //Delete
        studentController.delete(student);
        System.out.println("\n-- After Deleting Student --");
        studentList = studentController.findAll();
        studentList.stream().forEach(s -> System.out.println(s.getName()));


        System.out.println("************************************");


    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Student", Student.class).getResultList().size();
    }

    private static void saveTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        Course course = new Course("Matematik", "Mat101", 5);
        Course course2 = new Course("Fizik", "Phy101", 4);
        Course course3 = new Course("Kimya", "Chm101", 3);

        Instructor visitingResearcher = new VisitingResearcher("Veli Ziyaretçi", "Veli adres", "05555526454", 34.55);
        Instructor permanentIntructor = new PermanentInstructor("Ahmet Kalıcı", "Ahmet adres", "05553168596", 4567.89);

        Student student = new Student("Kemal Öğrenci", "Kemal Adres", LocalDate.of(2010, Month.JANUARY, 1), "Male");
        Student student2 = new Student("Zeynep Öğrenci", "Zeynep Adres", LocalDate.of(2009, Month.MARCH, 23), "Female");
        Student student3 = new Student("Ayşe Öğrenci", "Ayşe Adres", LocalDate.of(2011, Month.APRIL, 19), "Female");

        course.getStudentList().addAll(Arrays.asList(student, student2));
        course2.getStudentList().addAll(Arrays.asList(student2, student3));
        course3.getStudentList().addAll(Arrays.asList(student, student2, student3));

        course.setInstructor(visitingResearcher);
        course2.setInstructor(permanentIntructor);
        course3.setInstructor(permanentIntructor);

        permanentIntructor.getCourseList().addAll(Arrays.asList(course2, course3));
        visitingResearcher.getCourseList().add(course);

        student.getCourseList().addAll(Arrays.asList(course, course3));
        student2.getCourseList().addAll(Arrays.asList(course, course2, course3));
        student3.getCourseList().addAll(Arrays.asList(course2, course3));

        try {
            em.getTransaction().begin();

            em.persist(course);
            em.persist(course2);
            em.persist(course3);

            em.persist(permanentIntructor);
            em.persist(visitingResearcher);

            em.persist(student);
            em.persist(student2);
            em.persist(student3);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
