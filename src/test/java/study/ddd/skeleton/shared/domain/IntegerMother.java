package study.ddd.skeleton.shared.domain;

public class IntegerMother {

    public static Integer random() {
        return MotherCreator.random().number().randomDigit();
    }

}
