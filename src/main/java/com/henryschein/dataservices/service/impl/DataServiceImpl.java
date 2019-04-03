package com.henryschein.dataservices.service.impl;

import java.io.BufferedReader;
import java.io.StringReader;
import javax.ws.rs.Path;

import org.apache.commons.lang.StringUtils;

import com.henryschein.dataservices.service.IDataService;

@Path("/")
public class DataServiceImpl implements IDataService {

	@Override
	public String reformat(String unformattedString) throws Exception {
		if (StringUtils.isNotBlank(unformattedString)) {
			String line;
			BufferedReader br = new BufferedReader(new StringReader(unformattedString));
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				line = line.replaceFirst("\"", "[");
				line = line.replace("\",\"", "] [");
				line = line.replace("\",", "] [");
				line = line.replace(",\"", "] [");
				line = line.replace("\"", "]");
				sb.append(line + "\n");
			}
			return sb.toString();
		} else {
			throw new Exception("Value to be formatted can not be empty");
		}
	}

}
