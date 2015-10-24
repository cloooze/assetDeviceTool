package com.ericsson.assetDeviceTool;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.ericsson.assetDeviceTool.handler.AssetHandler;
import com.ericsson.assetDeviceTool.util.MsdpProperties;

public class AssetManager {
	
	private static final Logger logger = Logger.getLogger(App.class);
	
	private static final String DEFAULT_ASSET_FILE_PATH = MsdpProperties.getDefinition("file.asset.path");
	private static final String ACTION_UPDATE_META = "update";
	private static final String ACTION_SEARCH_META = "search";
	private static final String ACTION_SEARCH_ITEM = "search_item";
	private static final String ACTION_DELETE_ITEM = "delete_item";
	private static final String ACTION_CREATE_ITEM = "create_item";
	private static final String SEPARATOR = ";";

	public static void main(String[] args) {
		
		try {
			File assetFile = null;
			
			if (args.length > 0) {
				assetFile = new File(args[0]);
			} else {
				assetFile = new File(DEFAULT_ASSET_FILE_PATH);
			}
			
			InputStream targetStream = FileUtils.openInputStream(assetFile);
			List<String> assets = IOUtils.readLines(targetStream);
			
			AssetHandler assetHandler = new AssetHandler();
			
			for (String asset : assets) {
				if (asset.isEmpty() || asset.startsWith("#")) {
					continue;
				}
				String[] arrayAsset = asset.trim().split(SEPARATOR);
				String assetId = arrayAsset[0];
				String metaName = arrayAsset[1];
				String metaValue = arrayAsset[2];
				String action = arrayAsset[3];
				
				if (!action.isEmpty() && action.equalsIgnoreCase(ACTION_UPDATE_META)) {
					assetHandler.updateAsset(assetId, metaName, metaValue);
				}
				if (!action.isEmpty() && action.equalsIgnoreCase(ACTION_SEARCH_META)) {
					assetHandler.searchMetaAsset(assetId, metaName, null);
				}
				if (!action.isEmpty() && action.equalsIgnoreCase(ACTION_SEARCH_ITEM)) {
					assetHandler.searchItemsByGroupId(assetId, metaName);		    		
				}
				if (!action.isEmpty() && action.equalsIgnoreCase(ACTION_CREATE_ITEM)) {
					//TODO enhance efficiency
					Map<String, String> assetidSkuMapping = new HashMap<String, String>();
					assetHandler.searchMetaAsset(assetId, "sku", assetidSkuMapping);
					assetHandler.createItem(assetId, metaName, metaValue, assetidSkuMapping);		    		
				}
				if (!action.isEmpty() && action.equalsIgnoreCase(ACTION_DELETE_ITEM)) {
					List<String> itemIdList = assetHandler.searchItemsByGroupId(assetId, metaName);
					assetHandler.deleteItemsByGroupId(assetId, metaName, itemIdList);
				}
			}
			
		}catch(Exception e) {
			logger.error(e, e);
		}
		
		logger.info("Execution complete");
	}
}

