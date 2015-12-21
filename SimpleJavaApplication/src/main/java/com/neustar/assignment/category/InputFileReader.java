package com.neustar.assignment.category;

import java.io.IOException;

/**
 * This is the interface to implement file reading and passing the data into inputDataHolder.
 * 
 * @author Krishnagopal Thogiti
 *
 */
public interface InputFileReader {

	/**
	 * This method returns the inputDataHolder to obtain data
	 * 
	 * @return the inputDataHolder
	 */
	InputDataHolder getInputDataHolder();

	/**
	 * This method reads the file and the saves data to inputDataHolder.
	 * 
	 * @throws IOException
	 */
	void readFile() throws IOException;

}