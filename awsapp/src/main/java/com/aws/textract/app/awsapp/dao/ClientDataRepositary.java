package com.aws.textract.app.awsapp.dao;

import java.util.Map;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDataRepositary extends MongoRepository<Map<String,Object> , String>{

}
