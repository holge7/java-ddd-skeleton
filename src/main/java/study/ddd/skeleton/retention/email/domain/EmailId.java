package study.ddd.skeleton.retention.email.domain;

import study.ddd.skeleton.shared.domain.Identifier;

public class EmailId extends Identifier {

    public EmailId(String value) {
        super(value);
    }

    public EmailId() {
        super("");
    }
}