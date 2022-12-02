package com.miracle.claims.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.miracle.claims.entity.Claim;


public interface ClaimsRepository extends MongoRepository<Claim, String> {

	public Claim deleteByServiceProviderClaimId(long claimId);
	public Claim findByServiceProviderClaimId(long claimId);

}