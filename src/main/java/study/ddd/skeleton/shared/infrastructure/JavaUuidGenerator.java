package study.ddd.skeleton.shared.infrastructure;

import org.springframework.stereotype.Service;
import study.ddd.skeleton.shared.domain.UuidGenerator;

import java.util.UUID;

@Service
public class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
