package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.shared.domain.Identifier;

public class StudentId extends Identifier {

    public StudentId(String value) {
        super(value);
    }

    public StudentId() {
        super("");
    }



}
