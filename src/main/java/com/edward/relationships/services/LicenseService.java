package com.edward.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edward.relationships.models.License;
import com.edward.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository licenseRepository;
	
//	public LicenseService(LicenseRepository licenseRepository) {
//		this.licenseRepository = licenseRepository;
//	}
	
	public List<License> allLicenses(){
		return licenseRepository.findAll();
	}
	
	public License createLicense(License l) {
		return licenseRepository.save(l);
	}
	
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepository.findById(id);
		if(optionalLicense.isPresent()) {
			return optionalLicense.get();
		} else {
			return null;
		}
	}
}
