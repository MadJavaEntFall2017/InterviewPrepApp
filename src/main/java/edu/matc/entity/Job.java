package edu.matc.entity;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static java.time.LocalDate.now;


/**
 * A class to represent a category.
 *
 * @author Natasha Grant
 */

@Entity
@Table(name = "jobs")
public class Job {

    @Column(name="name")
    private String jobName;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "jobId")
    private int jobID;


    /**
     * Instantiates a new User.
     */
    public Job() {
    }

    /**
     * Instantiates a new User.
     *
     * @param jobName   name of job
     * @param jobID    id of job
     */
    public Job(String jobName, int jobID) {
        this.jobName = jobName;
        this.jobID = jobID;
    }

    /**
     * Gets job name
     * @return the job name
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * Sets the job name
     * @param jobName
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * Gets job id
     * @return the jobID
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * Sets the job id
     * @param jobID
     */
    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    @Override
    public String toString() {
        return "Category{" +
                "jobName='" + jobName + '\'' +
                ", jobID=" + jobID +
                '}';
    }

}

