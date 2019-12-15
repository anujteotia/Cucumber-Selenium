package utils;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @author AnujTeotia
 *
 */
public class CreateFolder {
	public final static Logger logger = LogManager.getLogger(CreateFolder.class);
	
	private CreateFolder(){
		
	}

	/**
	 * 
	 * @param name of the Folder you want to create.
	 */
	public static void makeFolder(String name) {
		File folderName = new File(System.getProperty("user.dir") + "/" + name);
		if (!folderName.exists()) {
			logger.info("creating directory: " + folderName.getName());
			boolean result = false;

			try {
				folderName.mkdir();
				result = true;
			} catch (Exception e) {
				logger.info(e.getMessage());
				throw e;
			}
			if (result) {
				logger.info("Folder created " + name);
			}
		} else {
			logger.info(name + " already Exist!!");
		}

	}
}