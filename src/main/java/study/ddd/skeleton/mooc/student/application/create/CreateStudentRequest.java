package study.ddd.skeleton.mooc.student.application.create;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateStudentRequest {
    String id;
    String name;
    String surname;
    String email;
}
