package service;

import model.Student;
import repository.CrudRepository;
import util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public void save(Student student) {
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    @Override
    public void delete(Student student) {
        em.remove(student);
    }
}
