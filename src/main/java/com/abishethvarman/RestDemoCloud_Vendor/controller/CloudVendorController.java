package com.abishethvarman.RestDemoCloud_Vendor.controller;

import com.abishethvarman.RestDemoCloud_Vendor.model.CloudVendor;
import com.abishethvarman.RestDemoCloud_Vendor.response.ResponseHandler;
import com.abishethvarman.RestDemoCloud_Vendor.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
//    CloudVendor cloudVendor;
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService){
        this.cloudVendorService = cloudVendorService;
    }

    //Read specific cloud vendor
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        return ResponseHandler.responseBuilder("Requested Vendor Details are given here",
                HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
    }

    //Read all cloud vendors
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return  cloudVendorService.getAllCloudVendor();
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.createCloudVendor(cloudVendor);
        return "Cloud Vendor successfully created";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated successfully.";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetailsByID(@PathVariable("vendorId") String vendorId) {
        cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted successfully.";
    }
}

