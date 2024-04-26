package com.aws.textract.app.awsapp.textract;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.textract.TextractClient;
import software.amazon.awssdk.services.textract.model.AnalyzeExpenseRequest;
import software.amazon.awssdk.services.textract.model.AnalyzeExpenseResponse;
import software.amazon.awssdk.services.textract.model.AnalyzeExpenseResponse.Builder;
import software.amazon.awssdk.services.textract.model.Document;
import software.amazon.awssdk.services.textract.model.S3Object;

@Component

public class Textract {
	
	public List<Object> getTextract() {
		S3AsyncClient client = S3AsyncClient.builder().region(Region.US_EAST_1).build();

		CompletableFuture<ResponseBytes<GetObjectResponse>> responseFuture = client.getObject(
				GetObjectRequest.builder().bucket("demobuckettextract").key("Invoice-1.pdf").build(),
				AsyncResponseTransformer.toBytes());

		List<AnalyzeExpenseResponse> finalResult = new LinkedList<AnalyzeExpenseResponse>();
		List<Object> finalbuilder = new LinkedList<Object>();

		CompletableFuture<ResponseBytes<GetObjectResponse>> operationCompleteFuture = responseFuture
				.whenComplete((getObjectResponse, exception) -> {
					if (getObjectResponse != null) {

						TextractClient textractclient = TextractClient.builder().region(Region.US_EAST_1).build();

						AnalyzeExpenseRequest request = AnalyzeExpenseRequest.builder()
								.document(Document.builder().s3Object(
										S3Object.builder().name("Invoice-1.pdf").bucket("demobuckettextract").build())
										.build())
								.build();

						AnalyzeExpenseResponse result = textractclient.analyzeExpense(request);
						finalResult.add(result);

						List<Builder> findingResult = finalResult.stream().map(finding -> finding.toBuilder())
								.collect(Collectors.toList());

						finalbuilder.addAll(findingResult);

					} else {
						exception.printStackTrace();
					}
				});

		operationCompleteFuture.join();

		return finalbuilder;
	}
}
