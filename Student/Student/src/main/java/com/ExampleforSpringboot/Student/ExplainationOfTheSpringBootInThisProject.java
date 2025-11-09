//🧩 OVERVIEW — 3-Layer Architecture in Spring Boot
//
//Layer	             |Class Example:	         |Purpose:	                                           |Example Task:
//
//Controller	     |StudentController	         |Handles API requests (HTTP GET/POST/etc.)	           |Receives a request like /students, calls Service
//service	         |StudentService	         |Contains business logic (main processing part)       |Decides how to add, fetch, or validate students
//Repository	     |StudentRepository	         |Talks to the database	                               |Saves or fetches data from the database



//📘 Simple Example: “Student Management” API
//Let’s say you want to create a small API where you can:
//Add a new student
//Get all students
//
//We’ll use 4 classes:
//1. Student → Model (represents data)
//2. StudentRepository → Repository layer
//3. StudentService → Service layer
//4. StudentController → Controller layer
//NOTE : THERE IS ALSO STUDENT DTO CLASS TO TRANSFER THE DATA BETWEEN THE LAYERS





//🧱 1️⃣ Model Layer — Student.java..................................................
//This class represents the data structure (Entity/Table)
//
//🏦 2️⃣ Repository Layer — StudentRepository.java
//💡 Main purpose: Handle data storage
//   For now, we’ll use a HashMap instead of a real database for simplicity
//
//⚙️ 3️⃣ Service Layer — StudentService.java
//💡 Main purpose: Holds business logic — meaning, you can process data, add validation, or combine multiple repository calls.
//
//🌐 4️⃣ Controller Layer — StudentController.java
//💡 Main purpose: Handle API endpoints — receives HTTP requests and sends responses.
//NOTE : THERE IS ALSO STUDENT DTO CLASS TO TRANSFER THE DATA BETWEEN THE LAYERS




//🔧 Dependency Injection with @Autowired...............................................
//THEY ARE THREE INGECTIOS OF AUTOWIRED
//FIELD INJECTION :
//EXAMPLE FOR THE FIELD INJECTION
//import org.springframework.beans.factory.annotation.Autowired;
//@Autowired
//private StudentRepository studentRepository;

//CONSTRUCTOR INJECTION
//EXAMPLE FOR THE CONSTRUCTOR INJECTION
//public ExampleOfConstructorInjection(StudentRepository studentRepository) {
//    this.studentRepository = studentRepository;
//}

//SETTER INJECTION
//EXAMPLE FOR THE SETTER INJECTION
//@Autowired
//public void setStudentRepository(StudentRepository studentRepository) {
//    this.studentRepository = studentRepository;
//}