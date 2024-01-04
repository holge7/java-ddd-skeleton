package study.ddd.skeleton.mooc.course.application.create;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.mooc.course.domain.CourseDuration;
import study.ddd.skeleton.mooc.course.domain.CourseId;
import study.ddd.skeleton.mooc.course.domain.CourseName;
import study.ddd.skeleton.shared.domain.bus.command.CommandHandler;

@Service
public class CreateCourseCommandHandler implements CommandHandler<CreateCourseCommand> {

    private final CourseCreator creator;

    public CreateCourseCommandHandler(CourseCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateCourseCommand command) {
        CourseId id = new CourseId(command.id());
        CourseName name = new CourseName(command.name());
        CourseDuration duration = new CourseDuration(command.duration());

        creator.create(id, name, duration);
    }
}
