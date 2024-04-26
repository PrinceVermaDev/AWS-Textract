package com.aws.textract.app.awsapp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.textract.app.awsapp.dao.ClientDataRepositary;

@Service
public class ClientDataServiceImpl implements ClientDataService{

	@Autowired
	private ClientDataRepositary clientDataRepositary;
	
	@Override
	
	public Map<String, Object> addclientData(Map<String, Object> clientData) {
		
		return this.clientDataRepositary.insert(clientData);
	}

}
