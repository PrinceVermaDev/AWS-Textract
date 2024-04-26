package com.aws.textract.app.awsapp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.textract.app.awsapp.service.ClientDataService;
import com.aws.textract.app.awsapp.textract.Textract;

//import software.amazon.awssdk.services.textract.model.AnalyzeExpenseResponse.Builder;

@RestController
public class TextractController {

	@Autowired
	private Textract textract;
	
	@Autowired
	private ClientDataService clientDataService;

	@GetMapping("client")
	public Map<String, Object> getTextract() {
		List<Object> list=this.textract.getTextract();
		Map<String , Object> finalData=new LinkedHashMap<>();
		finalData.put("1", list);
		//this.clientDataService.addclientData(finalData);
		return finalData;
	}

}
