package dev.binarycoders.springbootsecurity.student;

import dev.binarycoders.springbootsecurity.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/{id}")
    public Student get(@PathVariable final Integer id) {
        return studentService.get(id);
    }
}
