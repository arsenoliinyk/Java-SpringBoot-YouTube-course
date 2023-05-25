package ua.lviv.iot.spring.first.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.first.business.StudentService;
import ua.lviv.iot.spring.first.rest.model.Student;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/students")
@RestController
public class StudentsController {

    private Map<Integer, Student> students = new HashMap<>();

    private AtomicInteger idCounter = new AtomicInteger();

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getStudents(@RequestParam(name = "firstName", required = false) String firstName) {
        /*
        return new LinkedList<Student>(students.values());
        */
        List<Student> studentsList = Objects.isNull(firstName)||firstName.isEmpty()
                ? studentService.getAllStudents()
                : studentService.getAllByFirstName(firstName);

        return studentsList;

        /*if (firstName == null) {
            return studentService.getAllStudents();
        }
        return studentService.getAllByFirstName(firstName);*/
    }

    @GetMapping(path =  "/{id}")
    public Student getStudent(@PathVariable("id") Integer studentId) {
        /*
        return students.get(studentId);
        */

        return studentService.getStudent(studentId);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Student createStudent(final @RequestBody Student student) {
        /*
        System.out.println(studentService.createStudent(student));

        student.setId(idCounter.incrementAndGet());
        students.put(student.getId(), student);
        return student;
        */

        return studentService.createStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer studentId) {
        students.remove(studentId);
        HttpStatus status = students.remove(studentId) == null
                ? HttpStatus.NOT_FOUND
                : HttpStatus.OK;
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path =  "/{id}")
    public Student updateStudent(final @PathVariable("id") Integer studentId,
                                 final @RequestBody Student student) {
        student.setId(studentId);
        return students.put(studentId, student);
    }
}
