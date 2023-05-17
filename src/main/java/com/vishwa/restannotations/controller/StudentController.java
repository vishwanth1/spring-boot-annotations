package com.vishwa.restannotations.controller;

import com.vishwa.restannotations.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student("Vishwa", "G", 1);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Vishwa", "G", 1));
        students.add(new Student("Sunny", "G", 2));
        students.add(new Student("sai", "V", 3));
        students.add(new Student("ram", "N", 4));

        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> getStudentDetails(@PathVariable("id") int studentId,
                                     @PathVariable("first-name") String firstName,
                                     @PathVariable("last-name") String lastName) {
        return ResponseEntity.ok(new Student(firstName, lastName, studentId));
    }

    @GetMapping("/query")
    public ResponseEntity<Student> getStudentOnId(@RequestParam("studentId") int id,
                                  @RequestParam("first-name") String firstName,
                                  @RequestParam("last-name") String lastName) {
        return ResponseEntity.ok(new Student(firstName, lastName, id));
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.status(HttpStatus.CREATED).header("sample-header", "vishwa").body(student);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable int id) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        return ResponseEntity.ok("Deleted Successfully");
    }
}
