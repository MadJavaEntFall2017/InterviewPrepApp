package edu.matc.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.time.LocalDate.now;


/**
 * A class to represent a category.
 *
 * @author Natasha Grant
 */

@Entity
@Table(name = "jobs", catalog = "interviewdb", uniqueConstraints = @UniqueConstraint(columnNames = "jobId"))
public class Job implements java.io.Serializable{

    @Column(name="name")
    private String jobName;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "jobId")
    private int jobID;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "jobs_category_lnk", catalog = "interviewdb", joinColumns = {
            @JoinColumn(name = "jobsId", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "categoryId",
                    nullable = false, updatable = false) })
    private List<Category> categories = new ArrayList<>(0);

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


    public List<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "jobName='" + jobName + '\'' +
                ", jobID=" + jobID +
                '}';
    }

}

