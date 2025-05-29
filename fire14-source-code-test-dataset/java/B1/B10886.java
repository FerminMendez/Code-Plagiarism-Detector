package de.at.codejam.util;

import java.io.IOException;

public interface InputFileParser<CASE> {

	void initialize(TaskStatus taskStatus);

	TaskStatus getTaskStatus();

	boolean hasNextCase();

	CASE getNextCase() throws IOException;
}
