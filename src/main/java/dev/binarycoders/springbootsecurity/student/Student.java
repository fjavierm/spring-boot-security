package dev.binarycoders.springbootsecurity.student;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private final Integer id;
    private final String name;
}
