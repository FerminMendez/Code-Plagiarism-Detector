package org.moriraaca.codejam;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SolverConfiguration {
	OutputDestination outputDestination() default OutputDestination.STDOUT;

	String inputFileName() default "sample.in";

	DebugOutputLevel debugOutputLevel() default DebugOutputLevel.SOLUTION;

	Class<? extends AbstractDataParser> parser();
}
