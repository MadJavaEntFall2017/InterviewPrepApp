package edu.matc.persistence;


import edu.matc.entity.*;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;


/**
 * Created by ngrant 11/1/17
 */
public class GeneralDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all jobs
     *
     * @return All jobs
     */
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<Job>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        jobs = session.createCriteria(Job.class).list();
        return jobs;
    }

    /** Return a list of all categories
     *
     * @return All categories
     */
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        categories = session.createCriteria(Category.class).list();
        return categories;
    }

    /** Return a list of all flashcards
     *
     * @return All flashcards
     */
    public List<Flashcard> getAllFlashcards() {
        List<Flashcard> flashcards = new ArrayList<Flashcard>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        flashcards = session.createCriteria(Flashcard.class).list();
        return flashcards;
    }

    /**
     * retrieve a job given their id
     *
     * @param id the job id
     * @return job
     */
    public Job getJob(int id) {
        Job job = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            job = (Job) session.get(Job.class, id);
        } catch (HibernateException hibernateException) {
            log.error("Error retrieving job with id: " + id, hibernateException);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return job;
    }
    /**
     * retrieve a category given id
     *
     * @param id the category id
     * @return category
     */
    public Category getCategory(int id) {
        Category category = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            category = (Category) session.get(Category.class, id);
        } catch (HibernateException hibernateException) {
            log.error("Error retrieving category with id: " + id, hibernateException);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return category;
    }


    public void deleteJob(int id) {

        Job job = new Job();
        job.setJobID(id);

        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(job);
            transaction.commit();
        } catch (HibernateException hibernateException1){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException hibernateException2) {
                    log.error("Error rolling back delete of job id: " + id, hibernateException2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void deleteCategory(int id) {

        Category category = new Category();
        category.setCategoryID(id);

        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(category);
            transaction.commit();
        } catch (HibernateException hibernateException1){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException hibernateException2) {
                    log.error("Error rolling back delete of category id: " + id, hibernateException2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }


    /**
     * Update the job
     * @param job
     */

  public void updateUser(Job job) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(job);
            transaction.commit();
        } catch (HibernateException hibernateException1){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException hibernateException2) {
                    log.error("Error rolling back save of user: " + job, hibernateException2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * add a job
     *
     * @param job
     * @return the id of the inserted record
     */
/**   public int addJob(Job job) {
 int id = 0;
 Transaction transaction = null;
 Session session = null;
 try {
 session = SessionFactoryProvider.getSessionFactory().openSession();
 transaction = session.beginTransaction();
 id = (int)session.save(job);
 transaction.commit();
 } catch (HibernateException hibernateException1){
 if (transaction != null) {
 try {
 transaction.rollback();
 } catch (HibernateException hibernateException2) {
 log.error("Error rolling back save of job: " + job, hibernateException2);
 }
 }
 } finally {
 if (session != null) {
 session.close();
 }
 }
 return id;
 }
 */



}
