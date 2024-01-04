package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.shared.domain.MotherCreator;

public class StudentEmailMother {

    public static StudentEmail create(String value) {
        return new StudentEmail(value);
    }

    public static StudentEmail random() {
        return new StudentEmail(MotherCreator.random().internet().emailAddress());
    }

}