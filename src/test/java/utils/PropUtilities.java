package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	public String getValueUsingKey(String key) {
		return propFile.getProperty(key);
	}

}
