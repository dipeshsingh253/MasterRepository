package com.maventemp.daoimpl;

import com.maventemp.config.HibernateConfiguration;
import com.maventemp.dao.StudentDao;
import com.maventemp.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {


    @Override
    public void saveStudent(Student student) {

        Transaction transaction = null;

        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.save(student);

            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }

    }

    @Override
    public void updateStudent(Student student) {

        Transaction transaction = null;

        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.saveOrUpdate(student);

            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }

    }

    @Override
    public Student getStudentById(long id) {

        Transaction transaction = null;

        Student student = null;

        try(Session session = HibernateConfiguration.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            student = session.get(Student.class,id);

            transaction.commit();

        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }

        return student;
    }

    @Override
    public List<Student> getAllStudents() {

        Transaction transaction = null;

        List<Student> students = new ArrayList<>();

        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            students = session.createQuery("from Student").list();

            transaction.commit();


        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }

        return students;

    }

    @Override
    public void deleteStudent(long id) {

        Transaction transaction = null;

        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            session.delete(session.get(Student.class,id));

            transaction.commit();


        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }


    }
}
