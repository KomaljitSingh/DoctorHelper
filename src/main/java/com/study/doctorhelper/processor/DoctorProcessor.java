package com.study.doctorhelper.processor;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.doctorhelper.model.Address;
import com.study.doctorhelper.model.DoctorDetail;
import com.study.doctorhelper.model.Gender;
import com.study.doctorhelper.service.DoctorRepository;

@Service
public class DoctorProcessor {

	@Autowired
	private DoctorRepository doctorRepo;

	public DoctorProcessor(DoctorRepository doctorRepo) {
		
		this.doctorRepo = doctorRepo;
	}
	
	public void testRepo(){
		DoctorDetail doctorDetail = new DoctorDetail();
		doctorDetail.setDepartment("IT");
		doctorDetail.setDob(ZonedDateTime.now());
		doctorDetail.setDoctorId(12);
		doctorDetail.setDoctorName("Sahil");
		doctorDetail.setEmail("demo");
		doctorDetail.setExperience(1);
		doctorDetail.setGender(Gender.MALE);
		doctorDetail.setMobileNo("demo");
		doctorDetail.setPassword("demo");
		doctorDetail.setQualification("demo");
		doctorDetail.setSpecialist("demo");
		doctorDetail.setStatus(1);
		doctorDetail.setYearOfExperience(1);
		Address address = new Address();
		address.setCity("demo");
		address.setCountry("demo");
		address.setPincode(12);
		address.setState("demo");
		address.setStreetLine("demo");
		doctorDetail.setAddress(address);
		
		doctorRepo.saveDoctorDetails(doctorDetail);
	}
}
