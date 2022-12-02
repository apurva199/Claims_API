package com.miracle.claims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.miracle.claims.entity.Claim;
//import com.miracle.claims.entity.AddResponse;
import com.miracle.claims.repository.ClaimsRepository;


@Component
@Service
public class ClaimsServiceImpl implements ClaimsService {

	@Autowired
	ClaimsRepository claimsRepository;
	
	@Autowired
	ClaimsSequenceGeneratorService claimsSeqGeneratorSvc;

	// get the list of all
	@Override
	public ResponseEntity<List<Claim>> getAllClaims() {
		List<Claim> list = claimsRepository.findAll();
		return new ResponseEntity<List<Claim>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	// post
	@Override
	public ResponseEntity<Claim> createClaims(Claim claim) {
		claim.setServiceProviderClaimId(claimsSeqGeneratorSvc.generateSequence(Claim.SEQUENCE_NAME));
		Claim newClaim = claimsRepository.save(claim);
		
		return new ResponseEntity<Claim>(newClaim, new HttpHeaders(), HttpStatus.OK);
	}

	// put
	@Override
	public ResponseEntity<Claim> updateClaims(Long claimId, Claim claim) {
		try {
			Claim claims = claimsRepository.findByServiceProviderClaimId(claimId);
			System.out.println("this is service pro" +claims.getServiceProviderClaimId());
			// log.info("this is the output" + claims.getClaimId());
			claims.setClaimId(claim.getClaimId());
			claims.setFacilityId(claim.getFacilityId());
			claims.setDocumentType(claim.getDocumentType());
			claims.setClaimStatus(claim.getClaimStatus());
			claims.setPalletQuantity(claim.getPalletQuantity());
			claims.setClaimedAmount(claim.getClaimedAmount());
			claims.setClaimType(claim.getClaimType());
			claims.setCreationDate(claim.getCreationDate());
			claims.setLastUpdateDate(claim.getLastUpdateDate());
			claims.setClaimCloseDate(claim.getClaimCloseDate());
			claimsRepository.save(claims);
			return new ResponseEntity<Claim>(HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	//delete
	@Override
	public String deleteClaims(Long claimId) {
		claimsRepository.deleteByServiceProviderClaimId(claimId);
		return "claim deleted with id : " + claimId;
	}

	@Override
	public Claim getClaim(Long claimId) {
		
		return claimsRepository.findByServiceProviderClaimId(claimId);
	}
	
	
	
}

