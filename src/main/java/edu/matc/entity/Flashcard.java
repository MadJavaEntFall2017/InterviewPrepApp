package edu.matc.entity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.persistence.CascadeType;
import edu.matc.entity.Category;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.mapping.Set;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static java.time.LocalDate.now;

import java.io.Serializable;


/**
 * A class to represent a flashcard.
 *
 * @author Natasha Grant
 */


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



    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;







/**    public Category getCategory() {
        return category;
    } */




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
     * @param category the categoryID
     */
    public Flashcard(int flashcardID, String question, String answer, Category category) {
        this.flashcardID = flashcardID;
        this.question = question;
        this.answer = answer;
        this.category = category;

    }

    public Category getCategory() {return category;}

    public void setCategory(Category category) {
        this.category = category;
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
                ", categoryID='" + category + '\'' +
                '}';
    }

    /**
     * This method will
     */
    public void generateFlashCard(){


    }
}

