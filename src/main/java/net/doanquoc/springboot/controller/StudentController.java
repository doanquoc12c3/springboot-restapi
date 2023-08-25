package net.doanquoc.springboot.controller;

import net.doanquoc.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(
                1,
                "Doan",
                "Quoc"
        );
        return student;
    }

    // http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"doan", "quoc"));
        students.add(new Student(2,"doan1", "quoc2"));
        students.add(new Student(3,"doan2", "quoc3"));
        students.add(new Student(4,"doan3", "quoc4"));
        return students;
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



}
