package edu.matc.persistence;


import edu.matc.entity.Job;
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
    public void getJob() throws Exception {
        Job job = dao.getJob(3);
        assertTrue(job.getJobID() == 3);
    }






}