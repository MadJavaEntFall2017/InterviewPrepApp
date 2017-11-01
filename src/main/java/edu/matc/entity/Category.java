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
@Table(name = "category")
public class Category {

    @Column(name="name")
    private String categoryName;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "categoryId")
    private int categoryID;

 //   @ElementCollection(targetClass = Flashcard.class)
//    private List<Flashcard> flashcards;

/**    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    public List<Flashcard> getFlashcards() {
        return flashcards;
    }
*/


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
    public Category(String categoryName, int categoryID) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
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

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                ", categoryID=" + categoryID +
                '}';
    }

}
