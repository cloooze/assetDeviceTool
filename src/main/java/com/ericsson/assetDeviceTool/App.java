package com.ericsson.assetDeviceTool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import javax.xml.ws.*;

import com.drutt.ws.msdp.media.management.v3.Asset;
import com.drutt.ws.msdp.media.management.v3.Item;
import com.drutt.ws.msdp.media.management.v3.Meta;
import com.drutt.ws.msdp.media.management.v3.PaginationResult;
import com.ericsson.assetDeviceTool.api.MediaMgmtApi;
import com.ericsson.assetDeviceTool.bean.Device;

public class App 
{
	private static final Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args ) {
    	try {
    		List<Device> deviceList = new ArrayList<Device>();
    		
    		List<String> assetIdList = new ArrayList<String>();
    		
    		Map<String, String> mappa = new HashMap<String, String>();
    		
    		
    		List<Asset> listAsset = MediaMgmtApi.getAssetsByIdKey(0, 1000, null);
    		for (Asset asset : listAsset) {
    			
    			Device device = null;
    			
    			if (asset.getType().equals("phone")) {
    				mappa.put(asset.getAssetId(), null);
    				
    				assetIdList.add(asset.getAssetId());
    				
    				device = new Device();
    				device.setAssociatedAssetId(asset.getAssetId());
    				device.setDevice("smryph");
    				device.setIsDataOnly("false");
//    				device.setSku(asset.getOwnerAssetId());
    				
    				List<Meta> metas = asset.getMeta();
    				
    				for (Meta meta : metas) {
//    					logger.info("meta name: " + meta.getKey() + " meta value: " + meta.getValue());
    					if (meta.getKey().equals("userGuide")) {
    						device.setUserGuideName(meta.getValue());
    					}
    					if (meta.getKey().equals("brandId")) {
    						device.setBrandId(meta.getValue());
    					}
    					if (meta.getKey().equals("sku")) {
    						device.setSku(meta.getValue());
    					}
    				}
    				
    				deviceList.add(device);
    			}
    		}
    		
//    		logger.info(BeanToCsv.toCsv(deviceList));
    		
    		for (Asset asset : listAsset) {
    			
    			if (asset.getType().equals("device")) {
    				String associatedAssetId = null;
    				
    				for (Meta meta : asset.getMeta()) {
    					if (meta.getKey().equals("associatedShopId")) {
    						associatedAssetId = meta.getValue();
    						
    						Set<String> phoneIdList = mappa.keySet();
    						
    						for (String s : phoneIdList) {
    							if (s.equals(associatedAssetId)) {
    								mappa.put(s, asset.getAssetId());
    								
    							}
    						
    							
    						}
    					}
    				}
    				
    			}
    		}
    		
    		logger.info(mappa);
    		
    		
    		
    		
    		
    		List<Asset> listAssetResult = MediaMgmtApi.getAssetByAssetId(assetIdList);
    		
    		Holder<PaginationResult> holder = new Holder<PaginationResult>();
    		Holder<List<Item>> items = new Holder<List<Item>>();
    		
    		
    		List<String> uris = new ArrayList<String>();
    		for (Asset asset : listAssetResult) {
    			try {
    				MediaMgmtApi.searchItems(asset.getAssetId(), "phoneDetails", holder, items);
    			}catch (Exception e) {
    				logger.error("item non trovato");
    			}
    			
    			
    			for (Item item : items.value) {
    				for (Meta meta : item.getMeta()) {
    					if (meta.getKey().equals("dimensions") && meta.getValue().equals("550x570")) {
//    						logger.info(item.getUri());
    						uris.add(item.getUri());
    						
    						
    					}
    				}
    			}
    		}
    		
    		
    		Map<String, String> mappaFinale = new HashMap<String, String>();
    		
    		
    		for (String phoneId : mappa.keySet()) {
    			for (String uri : uris) {
    				if (uri.contains(phoneId)) {
    					mappaFinale.put(mappa.get(phoneId), uri);
    				}
    			}
    		}
    		
    		logger.info("mappa finale: \n" + mappaFinale);
    		
    		
//    		logger.info(deviceList.toString());
    	} catch(Exception e) {
    		logger.error(e, e);
    	}
    }
}
