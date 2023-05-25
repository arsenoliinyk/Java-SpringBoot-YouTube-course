package ua.lviv.iot.spring.first.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.first.dataaccess.StudentRepository;
import ua.lviv.iot.spring.first.rest.model.Student;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllByFirstName(String firstName) {
        return studentRepository.findAllByFirstName(firstName);
    }

    public List<Student> getAllByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }
}
