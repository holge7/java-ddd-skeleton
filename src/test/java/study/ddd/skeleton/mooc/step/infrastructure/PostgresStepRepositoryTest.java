package study.ddd.skeleton.mooc.step.infrastructure;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import study.ddd.skeleton.mooc.step.StepModuleInfrastuctureTestCase;
import study.ddd.skeleton.mooc.step.domain.StepIdMother;
import study.ddd.skeleton.mooc.step.domain.challenge.ChallengeStepMother;
import study.ddd.skeleton.mooc.step.domain.video.VideoStepMother;
import study.ddd.skeleton.mooc.steps.domain.Step;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
public class PostgresStepRepositoryTest extends StepModuleInfrastuctureTestCase {

    @ParameterizedTest
    @MethodSource("steps")
    void save_valid_step(Step step) {
        repository.save(step);
    }

    @ParameterizedTest
    @MethodSource("steps")
    void search_an_existing_step(Step step) {
        repository.save(step);
        assertEquals(Optional.of(step), repository.search(step.id()));
    }

    @Test
    void not_find_a_not_existing_step() {
        assertFalse(repository.search(StepIdMother.random()).isPresent());
    }


    private static List<? extends Step> steps() {
        return Arrays.asList(ChallengeStepMother.random(), VideoStepMother.random());
    }


}