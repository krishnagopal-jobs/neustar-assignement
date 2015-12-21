/**
 * 
 */
package com.neustar.assignment.category;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides implementation for InputFileReader
 * 
 * @author Krishnagopal Thogiti
 */
public class InputFileReaderImpl implements InputFileReader {


	public final static Logger logger = LoggerFactory.getLogger(InputFileReaderImpl.class);
	
	private Path inputFilePath;
	
	private InputDataHolder inputDataHolder;

	/**
	 * 
	 * This creates new instances FileReader which holds the reference to inputDataHolder.
	 * 
	 */
	public InputFileReaderImpl(String filePath) {
		inputFilePath = Paths.get(filePath);
		logger.info("inputFilePath :" + inputFilePath.toAbsolutePath());
		inputDataHolder = new InputDataHolderImpl();
	}

	/* (non-Javadoc)
	 * @see com.neustar.assignment.category.InputFileReader#getInputDataHolder()
	 */
	@Override
	public InputDataHolder getInputDataHolder() {
		return inputDataHolder;
	}

	/* (non-Javadoc)
	 * @see com.neustar.assignment.category.InputFileReader#readFile()
	 */
	@Override
	public void readFile() throws IOException {

		try (BufferedReader reader = Files.newBufferedReader(inputFilePath)) {
			String dataRow = null;
			while((dataRow = reader.readLine()) != null) {
				try {
					inputDataHolder.addDataRow(dataRow);
				} catch (InvalidDataRowException e) {
					logger.warn("Datarow is invalid :" + dataRow);
				}
			}
		}

	}

}
