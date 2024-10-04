project name: "testTusk"

the project was created as part of a test task.
(need to know "https://www.baeldung.com/cs/string-similarity-edit-distance")

used technology stack:
- java 17
- spring boot
- postgres
- docker

functionality:
when the application is launched, the database is migrated, 
the database tables are filled with entities whose fields are taken from the data of the jason files, 
an algorithm is performed to calculate the stop factor according to the conditions described in the task.

launch:
you can launch the application by running the script "start.sh", located in the root of the project, 
which will run the tests, then build the project and launch the application and database in a docker container.
