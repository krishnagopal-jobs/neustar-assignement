/**
 * 
 */
package com.neustar.assignment.category;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Mocked;
import mockit.StrictExpectations;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

/**
 * @author Krishnagopal Thogiti
 *
 */
@RunWith(JMockit.class)
public class InputFileReaderImplTest {

	private InputFileReader inputFileReader;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		inputFileReader = new InputFileReaderImpl("filePath");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.neustar.assignment.category.InputFileReaderImpl#InputFileReaderImpl(java.lang.String)}
	 * .
	 */
	@Test
	public void testInputFileReaderImpl(@Mocked Paths paths) {

		new InputFileReaderImpl("filePath");

		new Verifications() {
			{
				paths.get("filePath");
				times = 1;
			}
		};
	}

	/**
	 * Test method for
	 * {@link com.neustar.assignment.category.InputFileReaderImpl#getInputDataHolder()}
	 * .
	 */
	@Test
	public void testGetInputDataHolder() {
		Assert.assertNotNull(inputFileReader.getInputDataHolder());
	}

	/**
	 * Test method for
	 * {@link com.neustar.assignment.category.InputFileReaderImpl#readFile()}.
	 * 
	 * @throws IOException
	 * @throws InvalidDataRowException 
	 */
	@Test
	public void testReadFile(@Mocked InputDataHolderImpl inputDataHolder, @Mocked Files files,
			@Mocked BufferedReader bufferedReader, @Mocked FileReader fileReader) throws IOException, InvalidDataRowException {
		new StrictExpectations() {
			{
				// files.newBufferedReader(Paths.get("filePath"));
				// result = new BufferedReader(new FileReader("filePath"));

				bufferedReader.readLine();
				result = "OTHER How are you";

				bufferedReader.readLine();
				result = "PLACE Where are you";

				bufferedReader.readLine();
				result = null;

				bufferedReader.close();
			}
		};
		
		inputFileReader.readFile();

		new Verifications() {{
			inputDataHolder.addDataRow(anyString);
			times=2;
		}};

	}

}
