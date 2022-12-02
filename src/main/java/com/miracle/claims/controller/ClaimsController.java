package com.miracle.claims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miracle.claims.entity.Claim;
import com.miracle.claims.service.ClaimsServiceImpl;

@RestController
public class ClaimsController {

	@Autowired
	private ClaimsServiceImpl claimsServices;

	@GetMapping("/claims")
	public ResponseEntity<List<Claim>> getAllClaims() {
		return claimsServices.getAllClaims();
	}

	@GetMapping("/claims/{claimId}")
	public ResponseEntity<Claim> getClaim(@PathVariable Long claimId) {
		return new ResponseEntity<Claim>(claimsServices.getClaim(claimId), new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/claims")
	public ResponseEntity<Claim> createClaims(@RequestBody Claim claim) {
		return claimsServices.createClaims(claim);
	}

	//
	@PutMapping("/claims/{claimId}")
	public ResponseEntity<Claim> updateClaim(@PathVariable Long claimId, @RequestBody Claim claim) {
		return claimsServices.updateClaims(claimId, claim);
	}

	@DeleteMapping("/claims/{claimId}")
	public String deleteClaims(@PathVariable Long claimId) {
		return claimsServices.deleteClaims(claimId);
	}
}