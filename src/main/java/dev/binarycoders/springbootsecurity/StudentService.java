package dev.binarycoders.springbootsecurity;

import dev.binarycoders.springbootsecurity.student.Student;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private static final List<Student> STUDENTS = new ArrayList<>();

    @PostConstruct
    public void init() {
        STUDENTS.add(Student.builder().id(1).name("John Doe").build());
        STUDENTS.add(Student.builder().id(2).name("Jane Doe").build());
        STUDENTS.add(Student.builder().id(3).name("Will Smith").build());
        STUDENTS.add(Student.builder().id(4).name("Anna Smith").build());
    }

    public Student get(final Integer id) {
        return STUDENTS.stream()
            .filter(student -> Objects.equals(student.getId(), id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException(String.format("Student %d not found", id)));
    }
}
