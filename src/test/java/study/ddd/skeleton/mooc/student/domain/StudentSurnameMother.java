package study.ddd.skeleton.mooc.student.domain;

import study.ddd.skeleton.shared.domain.WordMother;

public class StudentSurnameMother {

    public static StudentSurname create(String value){
        return new StudentSurname(value);
    }

    public static StudentSurname random() {
        return create(WordMother.random());
    }

}
