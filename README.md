CSRF-DEMO
What is CSRF?🤔
CSRF stands for Cross-Site Request Forgery.
It’s a type of web security attack where a malicious website tricks a logged-in user’s browser into sending unauthorized requests to a trusted web application.

Why do we use it in our Springboot Applications?
Protect state-changing requests → POST, PUT, DELETE are secured against forgery.
Built-in in Spring Security → you don’t need to implement token logic manually.
Industry standard → any production-grade Spring Boot app should have CSRF enabled (unless it’s a pure API backend).


In this project, I created a simple Student model with a list to store student details.
Using GET requests, I can fetch all students’ details without any problem.
But when I try to add a new student with a POST request, Spring Security blocks it and returns 403 Forbidden.
This happens because Spring Security enables CSRF protection by default for all state-changing requests (POST, PUT, DELETE).
👉 To solve this, I added a function getCsrfToken which returns the CSRF token from the server.

Now the process is:
Call GET /csrf-token → fetch the CSRF token.
Send the token in the header (X-CSRF-TOKEN) along with the POST request.
The server verifies the token → if it’s valid, the new student is added successfully.

📂 Project Structure & Code Explanation
1. Model Layer

Student.java (inside model package)
A simple class that represents a student.
Fields: id, name, password.
Used as a data model for storing and returning student details.

2. Controller Layer

HomeController.java (inside controller package)
Handles all incoming HTTP requests.

Endpoints:
GET / → Returns "Hello world" (test endpoint).
GET /Allstudents → Returns a list of students.
POST /student → Adds a new student to the list.
GET /csrf-token → Returns the current CSRF token so that clients (like Postman) can use it for secure requests.

