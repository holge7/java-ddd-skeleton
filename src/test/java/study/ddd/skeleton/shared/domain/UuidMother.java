package study.ddd.skeleton.shared.domain;

import com.github.javafaker.Faker;

import java.util.UUID;

public class UuidMother {
    public static String random() {
        return UUID.randomUUID().toString();
    }
}
