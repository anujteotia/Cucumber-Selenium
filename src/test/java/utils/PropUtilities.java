package utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * This class loads the properties file and returns the value of the given key.
 * 
 * @author anujteotia
 *
 */
public class PropUtilities {

	InputStream inputStream = null;
	Properties propFile = new Properties();
	public final static Logger logger = LogManager.getLogger(PropUtilities.class);

	public PropUtilities(String filename) {
		File file = new File(filename);
		try {
			inputStream = new FileInputStream(file);
			propFile.load(inputStream);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	/**
	 * @param key Name of key for which value needs to be fetched from properties
	 *            file.
	 * @return the values of the key provided.
	 */
	public String getValueUsingKey(String key) {
		return propFile.getProperty(key);
	}

}
