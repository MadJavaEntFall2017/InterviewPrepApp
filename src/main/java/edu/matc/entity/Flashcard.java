package edu.matc.entity;


//import edu.matc.util.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

import static java.time.LocalDate.now;


/**
 * A class to represent a user.
 *
 * @author Natasha Grant
 */


//TODO create the user entity to represent a user in your user table.
//TODO Remember to include a no argument constructor and publice getters and setters
//TODO Add hibernate annotations to allow mapping from your table to the entity
// Note: a LocalDate converter has been provided in the util package in case you need it
@Entity
@Table(name = "flashcard")
public class Flashcard {

    @Column(name="question")
    private String question;

    @Column(name="answer")
    private String answer;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "flashcardId")
    private int flashcardID;


    private Category category;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    public Category getCategory() {
        return category;
    }
    private int categoryID;



    /**
     * Instantiates a new User.
     */
    public Flashcard() {
    }

    /**
     * Instantiates a new User.
     *
     * @param flashcardID   the flashcard id
     * @param question    the question
     * @param answer      the answer
     * @param categoryID the categoryID
     */
    public Flashcard(int flashcardID, String question, String answer, int categoryID) {
        this.flashcardID = flashcardID;
        this.question = question;
        this.answer = answer;
        this.categoryID = categoryID;

    }

    /**
     * Gets the question
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the question
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets the answer
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the answer
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    /**
     * Gets flashcardID.
     *
     * @return the flashcardID
     */
    public int getFlashcardID() {
        return flashcardID;
    }

    /**
     * Sets flashcardID.
     *
     * @param flashcardID
     */
    public void setFlashcardID(int flashcardID) {
        this.flashcardID = flashcardID;
    }


    @Override
    public String toString() {
        return "Flashcard{" +
                "answer='" + answer + '\'' +
                ", question='" + question + '\'' +
                ", flashcardID='" + flashcardID + '\'' +
                ", categoryID='" + categoryID + '\'' +
                '}';
    }
}

