# Hobby-project
# Hobby Web Application - Overwatch League Fantasy Team Builder

This project's purpose was to build a full stack hobby web application, in this case building a fantasy team for the overwatch league. It implements full CRUD functionality, allowing the user to alter both the players and the teams they are on.
## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites
What things you need to install the software and how to install them

Java 14 - https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html

OpenJDK - https://adoptopenjdk.net/

MYSQL 8 - https://dev.mysql.com/downloads/installer/

Maven - https://maven.apache.org/download.cgi

Spring - https://spring.io/tools

Git - https://git-scm.com/downloads

Eclipse - https://www.eclipse.org/downloads/

For installing Java follow the instructions here: https://qa-community.co.uk/~/_/learning/java-beginner/java--installation 
For installing MYSQL follow the instructions here: https://qa-community.co.uk/~/_/learning/databases-introduction/databases--installation

### Installing
Installing the application requires cloning the git repository to your local system.
First, in Git Bash (assuming you've already downloaded and installed it), change to whichever directory you would like to clone the repository down to using (desktop is just an example):
```
cd desktop

```
Alternatively you can right click in the folder you want to clone to and select "Git Bash Here"

Use the following command to clone the git repository to your system:
```
git clone https://github.com/Diakoptes24/Hobby-project.git
```

To run the application you will need to either run the jar file or import the repository into an IDE such as Eclipse.

To run the jar file open Git Bash and run use the following command:
```
java -jar Hobby-project 0.0.1-SNAPSHOT.jar
```

If using Eclipse, import the project into you workspace:
*Navigate to file and then select Import
*Choose existing maven projects in the maven folder
*Choose the location of this cloned repository
*Finish
Once import run the "HobbyProjectApplication.java" as a Spring Boot App.

Once the program is running via either method, navigate to http://localhost:8080/ to access the site.

### Running the tests
The tests in this project were carried out with Junit, Mockito and Selenium.
To run all the tests right click the project folder in the package explorer and navigate to coverage as and select 2 JUnit test.
The tests run on a local h2 database, with the test cases not affecting each other thanks to it resetting before each

### Unit Tests
Explain what these tests test, why and how to run them

### Integration Tests
For integration testing this project utilised Mockito.

And coding style tests
## Deployment
Add additional notes about how to deploy this on a live system

##Sonarqube
Sonarqube identified 0 bugs, 2 vulnerabilities and 67 code smells. The vulnerabilities simply required replacing a persistent entity with a DTO object, while the code smells consisted mostly of commented out code blocks needing to be deleted, unused imports and some test methods being public.
## Jira
Here is the invite link: https://id.atlassian.com/invite/p/jira-software?id=hBb54fz-Sy-obZQJWO7D2w
You can find the Jira board for this project here: https://ims-scotts.atlassian.net/jira/software/projects/HP/issues/


## Built With
Maven - Dependency Management
## Versioning
We use SemVer for versioning.

## Authors
Scott Stevens - https://github.com/Diakoptes24
## License
This project is licensed under the MIT license - see the LICENSE.md file for details

For help in Choosing a license

## Acknowledgments
Thanks to my team for suggestions on getting through sticking points, as well as Alan for the help he provided. Also thanks to Jordan for the inspiration behind my approach to Spring.
