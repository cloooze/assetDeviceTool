package com.ericsson.assetDeviceTool.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import com.drutt.ws.msdp.media.search.v2.Asset;
import com.drutt.ws.msdp.media.search.v2.IndexerSearchApi;
import com.drutt.ws.msdp.media.search.v2.IndexerSearchService;
import com.drutt.ws.msdp.media.search.v2.SearchAssetsRequest;
import com.drutt.ws.msdp.media.search.v2.SearchAssetsResponse;
import com.drutt.ws.msdp.media.search.v2.WSException_Exception;
import com.ericsson.assetDeviceTool.util.MsdpProperties;


public class IndexerMgmtApi {
	
	private static IndexerMgmtApi indexerMgmtApi= null;
	private IndexerSearchService indexerService = null;
	private IndexerSearchApi indexerApi = null;
	
	private final static String DISCOUNT_providerId = MsdpProperties.getDefinition("mdsp.media.discount.providerid");
	private final static String DISCOUNT_serviceId = MsdpProperties.getDefinition("mdsp.media.discount.serviceid");
	private final static String PHONE_providerId = MsdpProperties.getDefinition("mdsp.media.phone.providerid");
	private final static String PHONE_serviceId = MsdpProperties.getDefinition("mdsp.media.phone.serviceid");
	
//	
	private static final String MSDP_ENDPOINT = MsdpProperties.getDefinition("msdp.indexer.api.endpoint");
	private static final String MSDP_API_USERNAME = MsdpProperties.getDefinition("msdp.media.api.username");
	private static final String MSDP_API_PASSWORD = MsdpProperties.getDefinition("msdp.media.api.password");
	
	public static IndexerMgmtApi getInstance() {
		if (indexerMgmtApi == null) {
			return new IndexerMgmtApi();
		}
		else 
			return indexerMgmtApi;
	}
	
	private IndexerMgmtApi () {
		try {
			indexerService = new IndexerSearchService(new URL(MSDP_ENDPOINT), new QName("http://ws.drutt.com/msdp/media/search/v2", "IndexerSearchService"));
//			indexerService = new IndexerSearchService();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		indexerApi = indexerService.getIndexerSearchApi();
		
		Map<String, Object> requestContext = ((BindingProvider)indexerApi).getRequestContext();
		
//		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, MSDP_ENDPOINT);
		requestContext.put(BindingProvider.USERNAME_PROPERTY, MSDP_API_USERNAME);
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, MSDP_API_PASSWORD);
	}
	
	public static SearchAssetsResponse getAssetsByExternalUrl(List<String> externalUrls) throws WSException_Exception {
    	SearchAssetsRequest searchAssetsRequest = new SearchAssetsRequest();
    	
    	searchAssetsRequest.setLangCode("en");
		searchAssetsRequest.getType().add("phone");
		searchAssetsRequest.setPageSize(100);
		
		StringBuilder sb = new StringBuilder();
		for (String s : externalUrls) {
			sb.append("externalUrl:");
			sb.append(s);
			sb.append(" OR ");
		}
		
		String finalQuery = sb.toString().substring(0, sb.toString().length() - 3);
		
		System.out.println(finalQuery);
		
		searchAssetsRequest.setQueryString(finalQuery);
    	
		return getInstance().getIndexerApi().searchAssets(searchAssetsRequest);
	}
	
	public static List<Asset> getAssetsByBrandId(String brandId) throws WSException_Exception {
		SearchAssetsRequest searchAssetsRequest = new SearchAssetsRequest();
    	
    	searchAssetsRequest.setLangCode("en");
		searchAssetsRequest.getType().add("phone");
		searchAssetsRequest.setPageSize(100);
		
		StringBuilder sb = new StringBuilder();
		sb.append("brandId:");
		sb.append(brandId);
		
		searchAssetsRequest.setQueryString(sb.toString());
    	
		SearchAssetsResponse resp = getInstance().getIndexerApi().searchAssets(searchAssetsRequest);
		return resp.getResult();
	}
	

	
	public IndexerSearchApi getIndexerApi() {
		return indexerApi;
	}
	
	
	
}
