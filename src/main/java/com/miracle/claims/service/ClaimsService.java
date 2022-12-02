package com.miracle.claims.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.miracle.claims.entity.Claim;

public interface ClaimsService {
	
	public ResponseEntity<List<Claim>> getAllClaims();
	
	public ResponseEntity<Claim> createClaims(Claim claim);
	
	public ResponseEntity<Claim> updateClaims(Long claimId, Claim claim);
	
	public String deleteClaims(Long claimId);
	
	public Claim getClaim(Long claimId);
}
