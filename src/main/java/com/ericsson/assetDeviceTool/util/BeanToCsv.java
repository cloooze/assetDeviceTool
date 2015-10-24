package com.ericsson.assetDeviceTool.util;

import java.util.List;

import com.ericsson.assetDeviceTool.bean.Device;

public class BeanToCsv {
	
	private final static String COMMA = ",";
	
	public static String toCsv(List<Device> listDevice) {
		StringBuilder csv = new StringBuilder();
		
		for (Device device : listDevice) {
			csv.append(device.getBrandId());
			csv.append(COMMA);
			csv.append(device.getAssociatedAssetId());
			csv.append(COMMA);
			csv.append(device.getDevice());
			csv.append(COMMA);
			csv.append(device.getIsDataOnly());
			csv.append(COMMA);
			csv.append(device.getSku());
			csv.append(COMMA);
			csv.append(device.getUserGuideName()==null?"":device.getUserGuideName());
			csv.append(COMMA);
			csv.append("\n");
		}
		
		return csv.toString();
	}

}
