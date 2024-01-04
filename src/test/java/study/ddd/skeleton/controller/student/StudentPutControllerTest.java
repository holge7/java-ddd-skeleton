package study.ddd.skeleton.controller.student;

import org.junit.jupiter.api.Test;
import study.ddd.skeleton.ApplicationTestCase;

import java.util.UUID;

final class StudentPutControllerTest extends ApplicationTestCase {

    @Test
    public void create_valid_student() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/student/"+ UUID.randomUUID(),
                "{\"name\":\"some-name\", \"surname\":\"some-surname\", \"email\":\"some@email.com\"}",
                201
        );
    }


}