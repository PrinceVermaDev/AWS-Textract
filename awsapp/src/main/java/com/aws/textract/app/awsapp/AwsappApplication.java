package com.aws.textract.app.awsapp;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.AnalyzeExpenseRequest;
import software.amazon.awssdk.services.textract.model.AnalyzeExpenseResponse;
import software.amazon.awssdk.services.textract.model.Document;
import software.amazon.awssdk.services.textract.model.S3Object;

@SpringBootApplication
public class AwsappApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(AwsappApplication.class, args);

//		S3AsyncClient client = S3AsyncClient.builder().region(Region.US_EAST_1).build();
//
//		String document = "Textract-Blog-6.png";
//		String bucket = "demobuckettextract";
//
//		CompletableFuture<ResponseBytes<GetObjectResponse>> responseFuture = client.getObject(
//				GetObjectRequest.builder().bucket("demobuckettextract").key("Textract-Blog-6.png").build(),
//				AsyncResponseTransformer.toBytes());
//       List<AnalyzeExpenseResponse> finalResult=new LinkedList<AnalyzeExpenseResponse>();
//		CompletableFuture<ResponseBytes<GetObjectResponse>> operationCompleteFuture = responseFuture
//				.whenComplete((getObjectResponse, exception) -> {
//					if (getObjectResponse != null) {
//
//						TextractClient textractclient = TextractClient.builder().region(Region.US_EAST_1).build();
//
//						AnalyzeExpenseRequest request = AnalyzeExpenseRequest
//								.builder().document(Document.builder().s3Object(S3Object.builder()
//										.name("Textract-Blog-6.png").bucket("demobuckettextract").build()).build())
//								.build();
//
//						AnalyzeExpenseResponse result = textractclient.analyzeExpense(request);
//						
//						//System.out.println(result.toString());
//				    
//						finalResult.add(result);
//
//
//					} else {
//						exception.printStackTrace();
//					}
//				});
//
//		
//		operationCompleteFuture.join();
//		//System.out.println(finalResult);
//		
//		String json=new ObjectMapper().writeValueAsString(finalResult);
//		
//		System.out.println(json);
//		

	}
	
}
