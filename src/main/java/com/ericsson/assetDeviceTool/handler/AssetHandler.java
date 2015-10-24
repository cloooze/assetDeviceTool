package com.ericsson.assetDeviceTool.handler;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.xml.ws.Holder;

import org.apache.log4j.Logger;

import com.drutt.ws.msdp.media.management.v3.Asset;
import com.drutt.ws.msdp.media.management.v3.Item;
import com.drutt.ws.msdp.media.management.v3.Meta;
import com.drutt.ws.msdp.media.management.v3.PaginationResult;
import com.drutt.ws.msdp.media.management.v3.WSException_Exception;
import com.drutt.ws.msdp.media.search.v2.SearchAssetsResponse;
import com.ericsson.assetDeviceTool.App;
import com.ericsson.assetDeviceTool.api.IndexerMgmtApi;
import com.ericsson.assetDeviceTool.api.MediaMgmtApi;
import com.ericsson.assetDeviceTool.util.MsdpProperties;

public class AssetHandler {
	
private static final Logger logger = Logger.getLogger(App.class);
	
	private final static String PHONE_PROVIDER_ID = MsdpProperties.getDefinition("mdsp.media.phone.providerid");
	private static final String GENIE_IMAGES_DIR = MsdpProperties.getDefinition("file.genie.images.path");
	
	public void createItem(String assetId, String groupId, String fileName, Map<String, String> assetidSkuMapping) {
		try {
			List<Item> itemList = new ArrayList<Item>();
			Item item = new Item();
			item.setIsExternallyHosted(false);
			item.setFilename(fileName);
			DataHandler value = new DataHandler(new URL(GENIE_IMAGES_DIR + assetidSkuMapping.get(assetId) + ".png"));
			item.setContent(value);
			
			itemList.add(item);
			
			Holder<List<Item>> holder = new Holder<List<Item>>(itemList);
			
			MediaMgmtApi.createItem(assetId, groupId, holder, false);
			
			logger.info("Item created in group " + groupId + " for Asset " + assetId);
		} catch(Exception e) {
			logger.error("Something went wrong during item creationg for asset " + assetId + " groupId " + groupId);
			logger.error(e);
		}
		
	}

	public static void testIndexer(String externalUrl) {
		// TODO Auto-generated method stub
		try {
			SearchAssetsResponse res = IndexerMgmtApi.getAssetsByExternalUrl(new ArrayList<String>(Arrays.asList(externalUrl.split(";"))));
			List<com.drutt.ws.msdp.media.search.v2.Asset> assets = res.getResult();
			logger.info("Result size: " + assets.size());
			for (com.drutt.ws.msdp.media.search.v2.Asset asset : assets) {
				for (com.drutt.ws.msdp.media.search.v2.Meta m : asset.getMeta()) {
					if (m.getKey().equalsIgnoreCase("externalurl")) {
						logger.info(asset.getAssetId() + " - " + m.getValue());
					}
				}
				
			}
		} catch (com.drutt.ws.msdp.media.search.v2.WSException_Exception e) {
			logger.error(e);
		}
		
	}
	
	public void deleteItemsByGroupId(String assetId, String groupId, List<String> itemIdList) {
		//TODO need also itemId
		try {
			MediaMgmtApi.deleteItems(assetId, groupId, itemIdList);
			logger.info("The following itemId have been delete from groupId " + groupId + " of asset " + assetId);
		} catch (WSException_Exception e) {
			logger.error("Something went wrong during delete items for asset " + assetId + " groupId " + groupId);
			logger.error(e);
			
		}
	}
	
	public List<String> searchItemsByGroupId(String assetId, String groupId) {
		Holder<PaginationResult> holder = new Holder<PaginationResult>();
		Holder<List<Item>> items = new Holder<List<Item>>();
		
		List<String> itemIdList = new ArrayList<String>();
		
		try {
			MediaMgmtApi.searchItems(assetId, groupId, holder, items);
				
			for (Item item : items.value) {
				if (item.getUri().contains("_th.png")) {
					logger.info("ItemId containing _th image " + item.getItemId() +" for asset " + assetId);
					itemIdList.add(item.getItemId());
				}
			}
		} catch (Exception e) {
			logger.error("Something went wrong during search items for asset " + assetId);
		}
		
		return itemIdList;
		
	}

	public String searchMetaAsset(String assetId, String metaName, Map<String, String> assetidMetaMapping) throws WSException_Exception {
		if (assetId.startsWith("A-")) {
			return searchMetaAssetByAssetId(assetId, metaName, assetidMetaMapping);
		}
		else {
			return  searchMetaAssetByExternalId(assetId, metaName, assetidMetaMapping);
		}
	}
	
	public String searchMetaAssetByAssetId(String assetId, String metaName, Map<String, String> assetidMetaMapping) throws WSException_Exception {
		List<String> assetList = new ArrayList<String>();
		assetList.add(assetId);
		Asset asset = MediaMgmtApi.getAssetByAssetId(assetList).get(0);
		
		for (Meta meta : asset.getMeta()) {
			if (meta.getKey().equalsIgnoreCase(metaName)) {
				logger.info("Meta key " + metaName + " found in Asset " + assetId + ". Value is " + meta.getValue());
				if (assetidMetaMapping != null) {
					assetidMetaMapping.put(assetId, meta.getValue());
				}
				return meta.getValue();
			}
		}
		
		logger.info("Meta key " + metaName + " not found in  Asset " + assetId);
		return null;
	}
	
	public String searchMetaAssetByExternalId(String assetId, String metaName, Map<String, String> assetidMetaMapping) throws WSException_Exception {
		List<String> assetList = new ArrayList<String>();
		assetList.add(assetId);
		Asset asset = MediaMgmtApi.getAssetByExternalId(assetId, PHONE_PROVIDER_ID).get(0);
		
		for (Meta meta : asset.getMeta()) {
			if (meta.getKey().equalsIgnoreCase(metaName)) {
				logger.info("Meta key " + metaName + " found in Asset " + assetId + ". Value is " + meta.getValue());
				return meta.getValue();
			}
		}
		
		logger.info("Meta key " + metaName + " not found in  Asset " + assetId);
		return null;
	}

	public void updateAsset(String assetId, String metaName, String metaValue) throws Exception {
		if (assetId.startsWith("A-")) {
			updateAssetsByAssetId(assetId, metaName, metaValue);
		}
		else {
			updateAssetsByExternalId(assetId, metaName, metaValue);
		}
	}

	private void updateAssetsByAssetId(String asset, String metaName, String metaValue) throws Exception {
		try {
			MediaMgmtApi.updateAssetPhoneMetaByAssetlId(asset,  metaName, metaValue);
			logger.info("Asset " + asset + " succesfully updated. New meta value " + metaName +"-" + metaValue);
		}catch (Exception e) {
			logger.error("Something went wrong updating asset " + asset);
		}
	}
	
	private void updateAssetsByExternalId(String asset, String metaName, String metaValue) throws Exception {
		MediaMgmtApi.updateAssetPhoneMetaByExternalId(asset, metaName, metaValue);
		
		logger.info("Asset " + asset + " succesfully updated. New meta value " + metaName +"-" + metaValue);
	}
	
}
