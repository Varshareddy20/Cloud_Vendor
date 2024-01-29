package com.varsha.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.varsha.restapidemo.CloudVendor;
import com.varsha.service.CloudVendorService;


@RestController //it is used to simplify the creation of restful apis
@RequestMapping("/cloudvendor")
public class CloudVendorController 
{
	CloudVendorService cloudVendorService;
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}

	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendorDetails(@PathVariable("vendorId")String vendorId) 
	{
		return cloudVendorService.getCloudVendor(vendorId);
				//("C1","Jay","Hyderabad","1234567891");
	}
	
	@GetMapping()
	public List<CloudVendor> getAllCloudVendorDetails() 
	{
		return cloudVendorService.getAllCloudVendors();
				//("C1","Jay","Hyderabad","1234567891");
	}
	
	@PostMapping	
	public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	{
		cloudVendorService.createCloudVendor(cloudVendor);
		return "Cloud Vendor Created Successfully";
	}
	
	@PutMapping	
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
	{
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud Vendor Updated Successfully";
	}
	
	@DeleteMapping("{vendorId}")	
	public String deleteCloudVendorDetails(@PathVariable("vendorId")String vendorId)
	{
		cloudVendorService.deleteCloudVendor(vendorId);
		return "Cloud Vendor Deleted Successfully";
	}
}
