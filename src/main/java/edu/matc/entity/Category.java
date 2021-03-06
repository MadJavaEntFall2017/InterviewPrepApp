package edu.matc.entity;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Set;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.*;

import static java.time.LocalDate.now;


/**
 * A class to represent a category.
 *
 * @author Natasha Grant
 */

@Entity
@Table(name = "category", catalog = "interviewdb", uniqueConstraints = @UniqueConstraint(columnNames="categoryId"))

public class Category implements java.io.Serializable{

    @Column(name="name")
    private String categoryName;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "categoryId")
    private int categoryID;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    public List<Flashcard> flashcards = new ArrayList<>(0);

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
    public List<Job> jobs = new ArrayList<>(0);
    /**
     * Instantiates a new User.
     */
    public Category() {
    }

    /**
     * Instantiates a new User.
     *
     * @param categoryName   name of category
     * @param categoryID    id of category
     */
    public Category(String categoryName, int categoryID, List<Flashcard> flashcards) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
        this.flashcards = flashcards;
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public void setFlashcards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    /**
     * Gets category name
     * @return the category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets category id
     * @return the categoryID
     */
    public int getCategoryID() {
        return categoryID;
    }

    /**
     * Sets the category id
     * @param categoryID
     */
    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }


    public List<Job> getJobs() {
        return this.jobs;
    }
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryID=" + categoryID +
                '}';
    }

}

