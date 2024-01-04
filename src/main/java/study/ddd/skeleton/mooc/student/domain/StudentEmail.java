package study.ddd.skeleton.mooc.student.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class StudentEmail {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public StudentEmail() {}


    String value;

    public StudentEmail(String value) {
        ensureValidEmail(value);

        this.value = value;
    }

    private void ensureValidEmail(String value) {
        if (!value.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("Invalid e-mail address: " + value);
        }
    }

    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEmail that = (StudentEmail) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
