package com.job.business;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

public class FileProcess {

	Logger logger = Logger.getLogger(FileProcess.class.getName());
	
	public void storeFile(String content, String fileName)throws Exception {
		// TODO Auto-generated constructor stub
		File file = new File(fileName);
		FileUtils.writeStringToFile(file, content);
		logger.info("File stored in: "+file.getAbsolutePath());
	}
	
	public String getFromFile(String path)throws Exception {
		// TODO Auto-generated constructor stub
		logger.info("File path: "+path);
		File file = new File(path);
		return FileUtils.readFileToString(file);
		
	}

}
