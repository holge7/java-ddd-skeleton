package study.ddd.skeleton.controller.health_check;

import org.junit.jupiter.api.Test;
import study.ddd.skeleton.ApplicationTestCase;

import static org.junit.jupiter.api.Assertions.*;

final class HealthCheckGetControllerTest extends ApplicationTestCase {

    @Test
    void check_health_check_is_working() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }

}