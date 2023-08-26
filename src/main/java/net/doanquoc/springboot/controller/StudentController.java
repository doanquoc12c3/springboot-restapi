package net.doanquoc.springboot.controller;

import net.doanquoc.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    // http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Doan",
                "Quoc"
        );
        return ResponseEntity.ok().header("custom-header","doanquoc").body(student);
        //return new ResponseEntity<>(student, HttpStatus.CONFLICT);
    }

    // http://localhost:8080/students
    @GetMapping("")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"doan", "quoc"));
        students.add(new Student(2,"doan1", "quoc2"));
        students.add(new Student(3,"doan2", "quoc3"));
        students.add(new Student(4,"doan3", "quoc4"));
        return ResponseEntity.ok(students);
    }


        // Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/doan/quoc
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName, lastName);
    }

    //Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=doan&lastName=quoc
    @GetMapping("query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    //Spring boot REST api that handles http post request -- create a new resources
    // @PostMapping and @RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


    //spring rest api that handles http put request -- updating existing resources
    @PutMapping("{id}/update")

    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        student.setId(studentId);
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // spring boot rest api that handles http delete request - deleting the existing resources
    @DeleteMapping("{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return "Student deleted successfully";
    }













}
