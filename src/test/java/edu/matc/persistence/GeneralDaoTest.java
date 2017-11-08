package edu.matc.persistence;

import java.util.Arrays;
import edu.matc.entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.junit.Before;
import org.junit.Test;



import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;


public class GeneralDaoTest {

    GeneralDao dao;
    int initialJobRecordAmount;
    int initialCategoryRecordAmount;
    int initialFlashcardRecordAmount;

    @Before
    public void setup() {
        dao = new GeneralDao();
        initialJobRecordAmount = dao.getAllJobs().size();
    }

   @Test
    public void getAllJobs() throws Exception {
        List<Job> jobs = dao.getAllJobs();
        assertTrue(jobs.size() > 0);
    }

    @Test
    public void getAllCategories() throws Exception {
        List<Category> categories= dao.getAllCategories();
        assertTrue(categories.size() > 0);
    }

    @Test
    public void getAllFlashcards() throws Exception {
        List<Flashcard> flashcards = dao.getAllFlashcards();
        assertTrue(flashcards.size() > 0);


        for (int i = 0; i < flashcards.size(); i++) {
            System.out.println(flashcards.get(i) + ", ");
        }

        Flashcard test = new Flashcard();
        System.out.println("To String:" + test.toString());


    }


    @Test
    public void getJob() throws Exception {
        Job job = dao.getJob(3);
        assertTrue(job.getJobID() == 3);
    }

    @Test
    public void getCategory() throws Exception {
        Category category = dao.getCategory(3);
        assertTrue(category.getCategoryID() == 3);
    }

/**    @Test
    public void addJob() throws Exception {
        Job job = new Job();
        job.setJobName("IT Help Desk");
        int jobID = dao.addJob(job);

        assertTrue(job.getJobID() == 4);
    }
*/

    @Test
    public void deleteJob() throws Exception {
        Job job = dao.getJob(3);
        dao.deleteJob(3);
        List<Job> jobs = dao.getAllJobs();

        assertFalse(jobs.contains(jobs));
    }

/**    @Test
    public void deleteCategory() throws Exception {
        Category category = dao.getCategory(6);
        dao.deleteCategory(6);
        List<Category> category = dao.getAllCategories();

        assertFalse(category.contains(category));
    }
*/






}