package com.neustar.assignment.category;

import java.io.IOException;

public interface InputFileReader {

	/**
	 * @return the inputDataHolder
	 */
	InputDataHolder getInputDataHolder();

	void readFile() throws IOException;

}