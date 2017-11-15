# InterviewPrepApp
# John Spink, Natasha Grant, Heather Entwistle Team project

Interview Prep App

### Problem Statement
Problem - 
IT students often come to interviews unprepared. This application will help prepare students in the IT field.
Interview Prep App will...

### uri Operations:

- json
1) Get /cards/flashCards/json
    returns all flashcards in json format
2) Get /cards/jobs/json
    returns all jobs in json format
3) Get /cards/categories/json
    returns all categories in json format
    
- html
1) GET /cards/job/html
    returns list of jobs in buttons that link to the same named jsp
2) GET /cards/categories/0/html
    0-2
    returns list of categories in a job as buttons that link to the same named jsp
3) GET /cards/flashcards/1/html
    1-6
    returns all flashcard answers and questions in a given category 1-6

- Provide categorized prep cards for different skillsets
- 

Wireframes:
_________________________________________________________________________________________________________________

### Application Flow

![Application Flow]()

_________________________________________________________________________________________________________________

### Flashcard Mockup

![Home Page](https://github.com/MadJavaEntFall2017/InterviewPrepApp/blob/master/DesignDocuments/Screenshot%20from%202017-10-25%2016-41-31.png)

_________________________________________________________________________________________________________________


### Database Design
![Database Design](https://github.com/MadJavaEntFall2017/InterviewPrepApp/blob/master/DesignDocuments/database.png)






### Project Technologies/Techniques 

* Security/Authentication: 

  * Admin role: create/read/update/delete (crud) of all data

  * User role: submit score peices, score edits, and events/alerts. 
    

* Database (MySQL and Hibernate)
  * users/roles/DAOs



* Web Services or APIs

  * Logging

  * Configurable logging using Log4J. In production, only errors will normally be logged, but logging at a debug level can be turned on to      facilitate trouble-shooting. 

  * Site and database hosted on AWS

  * Unit Testing

  * JUnit tests to achieve 80% code coverage 

### Design

* [Screen Design]()
* [Application Flow]()
* [Database Design]()

### [Project Plan]()

### [Time Log]() 
### [Journal]()
