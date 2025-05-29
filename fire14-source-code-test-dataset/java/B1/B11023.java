package org.moriraaca.codejam;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestConfiguration {
	Class<? extends AbstractSolver<? extends TestCase>> solverClass();
}
