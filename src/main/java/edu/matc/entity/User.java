package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
@Table(name = "users")
public class User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String emailAddress;

    @Column(name="instrument")
    private String instrument;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    private int userid;



    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userid      the userid
     * @param emailAddress the user email address
     * @param instrument  the user instrument
     */
    public User(String firstName, String lastName, String emailAddress, String instrument, int userid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.instrument = instrument;
        this.userid = userid;


    }

    /**
     * Calculate age int.
     *
     * @return the int
     */
/**    public int calculateAge() {
        if (dateOfBirth != null) {
            return Period.between(dateOfBirth, now()).getYears();
        } else {
            return 0;
        }

    }**/

    /**
     * Gets instrument
     * @return the instrument
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     * Sets the instrument
     * @param instrument
     */
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    /**
     * Gets the email address
     * @return the email address
     */
    public String getEmailAddress() {
         return emailAddress;
    }

    /**
     * Sets the email address
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }


    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", instrument='" + instrument + '\'' +
                ", userid=" + userid +
                '}';
    }
}
