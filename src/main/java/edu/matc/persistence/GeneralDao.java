package edu.matc.persistence;


import edu.matc.entity.Job;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class GeneralDao {

    private final Logger log = Logger.getLogger(this.getClass());

    /** Return a list of all categories
     *
     * @return All categories
     */
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<Job>();
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        jobs = session.createCriteria(Job.class).list();
        return jobs;
    }


    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public Job getJob(int id) {
        Job job = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            job = (Job) session.get(Job.class, id);
        } catch (HibernateException hibernateException) {
            log.error("Error retrieving user with id: " + id, hibernateException);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return job;
    }

    /**
     * add a user
     *
     * @param user
     * @return the id of the inserted record
     */
/**    public int addUser(User user) {
        int id = 0;
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            id = (int) session.save(user);
            transaction.commit();
        } catch (HibernateException hibernateException1){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException hibernateException2) {
                    log.error("Error rolling back save of user: " + user, hibernateException2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return id;
    }

    public void deleteUser(int id) {

        User user = new User();
        user.setUserid(id);

        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        } catch (HibernateException hibernateException1){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException hibernateException2) {
                    log.error("Error rolling back delete of user id: " + id, hibernateException2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
*/
    /**
     * Update the user
     * @param user
     */

/**    public void updateUser(User user) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = SessionFactoryProvider.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (HibernateException hibernateException1){
            if (transaction != null) {
                try {
                    transaction.rollback();
                } catch (HibernateException hibernateException2) {
                    log.error("Error rolling back save of user: " + user, hibernateException2);
                }
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

*/

}
