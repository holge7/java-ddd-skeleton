package study.ddd.skeleton.mooc.course.application.create;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class CreateCourseRequest {
    private String id;
    private String name;
    private String duration;

}
