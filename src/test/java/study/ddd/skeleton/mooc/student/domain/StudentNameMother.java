package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.shared.domain.WordMother;

public final class StudentNameMother {

    public static StudentName create(String value) {
        return new StudentName(value);
    }

    public static StudentName random() {
        return create(WordMother.random());
    }

}
