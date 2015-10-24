package com.ericsson.phone.features;


import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;

public class FeaturesManager {
	
	public static void main(String[] args) throws Exception {
		FeaturesManager fm = new FeaturesManager();
		
		String lineNoChar = getFiles().get(0);
//		String lineWithChar = getFiles().get(1);
		
		System.out.println(lineNoChar);
//		System.out.println(lineWithChar);
		
		String newL = StringEscapeUtils.unescapeHtml(lineNoChar);
		System.out.println(newL);
		
		
	}
	
	static List<String> getFiles() throws Exception {
		File assetFile = new File("C:\\Users\\ebragan\\workspace_sprint\\AssetDeviceTool\\assetDeviceTool\\src\\main\\resource\\phone_files");
		InputStream targetStream = FileUtils.openInputStream(assetFile);
		List<String> files = IOUtils.readLines(targetStream);
		targetStream.close();
		
		return files;
	}
	
}	
