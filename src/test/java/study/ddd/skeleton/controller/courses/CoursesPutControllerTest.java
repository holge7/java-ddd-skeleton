package study.ddd.skeleton.controller.courses;

import org.junit.jupiter.api.Test;
import study.ddd.skeleton.ApplicationTestCase;
import study.ddd.skeleton.controller.MoocApplicationTestCase;

import java.util.UUID;

public class CoursesPutControllerTest extends MoocApplicationTestCase {

    @Test
    void create_valid_course() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/courses/"+ UUID.randomUUID(),
                "{\"name\":\"The best course\", \"duration\":\"5 hours\"}",
                201
                );
    }

}