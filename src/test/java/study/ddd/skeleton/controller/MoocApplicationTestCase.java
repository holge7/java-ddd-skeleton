package study.ddd.skeleton.controller;

import org.springframework.transaction.annotation.Transactional;
import study.ddd.skeleton.ApplicationTestCase;

@Transactional("mooc-transaction_manager")
public abstract class MoocApplicationTestCase extends ApplicationTestCase {
}
