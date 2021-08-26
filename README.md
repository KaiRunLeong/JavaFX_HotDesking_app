# Readme

This README should be completed by the student

# 1. About

* Author: Kai Run Leong (S3862092)

* Course: Further Programming, (Semester 1, 2021)

* Content : This project is a simple hotdesking graphical user interface made for the employee of Arub.

* Possible User Difficulty: 
  1) Confusion might arise when whitelist alert appears. This is because instead of redirecting the user to <br/> the previous page, it will redirect them to the main menu.
  2) Users might not understand why multiple bookings are not allowed since there are no warning messages about the multiple bookings, therefore if the users were to attempt to make a subsequent booking the application will not have any response.
  3) Admin users might not notice that CSV reports have already been generated since a specific download location was not implemented.
  4) A minority of users might find the words difficult to read since resizing of the application was disabled.
  5) Confusion might arise if a user tries to book a date that has already been passed as no warning messages will appear. Rather, the system will not respond upon clicking the "next" button. 

# 2. Steps to be taken
* No specific steps are needed to run the application besides clicking on the run button to start the main class. The main class is an extension to the Application class in javafx. Therefore, to run a javafx application, it is important to call the start() method which initializes the first scene upon lauching in the main method.

* The only dependency which is required for this application to run as intended is the sqlite jar file. This is required so that java will be able to access the sqlite database to store important information such as employee details and booking information.

* Since there were no requirements stating that the application has to be converted into a .exe file. Upon downloading the source code, the user can immediately run the program through their console or IDE.

# 3. Execution examples
1) MVC architecture pattern was used in this coding assignment project. Therefore, depending on the controller needs, each controller should have its own model class. For example, the BookATableController.java has its own model class called BookATableModel.java. Furthermore, the model class contains all of the controller's logic since the controller is only meant to communicate between the view and model.
    
    <br/>Controller:
   
    ![Controller](images/Controller.png)

    <br/>Model:
    
    ![Model](images/Model.png)

    <br/>
    As shown, the controller's role is to update the view while the model is responsible for only updating data based on the user's input through the view.
    <br/>
    <br/>View (Table will be shown as booked based on the database): 
   
    ![View](images/View.png)


# Packaging
The main class is Main.java

Packaging for classes:
 - main.controller
 - main.model
 - main.view
Packaging for test:
 - test.model

## How to clone the project using intelliJIDEA and RUN the application
1- Download IntelliJ IDEA Ultimate Version (You had to apply for student license)

2- Open IntelliJ IDEA, select "File" from the top menu, select "New" and select "Project from Version Control"  

3- Copy your Github classroom repository and paste into URL, click on "Clone".
 Your project will be cloned and open in your IntelliJ IDEA window.
 
 However, you still need to add the SQLite jar file to your project so you can have access to your database. Follow next steps for adding the Jar file:
 
1- Download the SQLite JDBC jar file from week 7 Canvas module.

2- In your project under project root, make a new directory called lib and move the jar file into lib folder

3- Open IntelliJ IDEA, click on "File", open "Project Structure"

4- Under "Project Setting", select "Libraries"

5- Click + button, choose Java, and navigate to your project folder, then Lib folder, choose "sqlite-jdbc-3.34.0.jar", and click on "open"

6- Click on Apply and then OK to close the window

Now you are ready to Run the Application.

Simply right click on Main.java and choose Run.
Congratulations!

Login info:

Username: test

Password: test


## Prepare other content

Readme files are made for developers (including you), but also could be used for the final users.
So while you are writing your readme files please consider a few things:

1. What is about?
    - Your name and student number and course name on the top
    - Describe the content of your project or repository
    - Explain things the users would have a hard time understanding right away
2. What steps need to be taken?
    - Any specific steps for running your application, what is the main class?
    - Is there any requirements or dependencies?
    - After the installation, how they compile or run the code?
3. Execution examples
    - You could provide examples of execution with code and screenshots
    

other things you could add:

- Table of content
- Test cases
- Know bugs
- Things that have not been working or complete



### References and tutorials for Readme (Markdown)
- **IntelliJ IDEA MarkDown guide**. jetbrains.com/help/idea/markdown.html
- **Choose an open source license**. Github. Available at: https://choosealicense.com/
- **Getting started with writing and formatting on Github**. Github. Available at: https://help.github.com/articles/getting-started-with-writing-and-formatting-on-github/
- **Markdown here cheatsheet**. Markdown Here Wiki. Available at: https://github.com/adam-p/markdown-here/wiki/Markdown-Here-Cheatsheet
- **Markdown quick reference**. Wordpress. Available at: https://en.support.wordpress.com/markdown-quick-reference/
- **readme-template**. Dan Bader. Github. Available at: https://github.com/dbader/readme-template
- Writing READMEs. **Udacity**. Available at: https://classroom.udacity.com/courses/ud777/
