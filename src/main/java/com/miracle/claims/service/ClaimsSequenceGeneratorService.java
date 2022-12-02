package com.miracle.claims.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import org.springframework.stereotype.Service;

import java.util.Objects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;

import com.miracle.claims.entity.ClaimsSequence;

@Service
public class ClaimsSequenceGeneratorService {
	private MongoOperations mongoOperations;

	@Autowired
	public ClaimsSequenceGeneratorService(MongoOperations mongoOperations) {
	    this.mongoOperations = mongoOperations;
	}
	
	public long generateSequence(String seqName) {
        ClaimsSequence counter = ((mongoOperations) ).findAndModify(query(where("_id").is(seqName)),
                new Update().inc("sequence",1), options().returnNew(true).upsert(true),ClaimsSequence.class);
        return !Objects.isNull(counter) ? counter.getSequence() : 1;
    }
}

















