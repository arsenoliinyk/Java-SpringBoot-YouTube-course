package ua.lviv.iot.spring.first.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.spring.first.rest.model.Student;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    List<Student> findAllByFirstName(String firstName);

    List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);


    Student findBestStudent();

}
