package com.study.doctorhelper.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.doctorhelper.exception.ExceptionHandler;
import com.study.doctorhelper.model.DoctorDetail;
import com.study.doctorhelper.model.PatientDetail;
import com.study.doctorhelper.processor.DoctorProcessor;


/**
 * This controller provides the endpoints to process the doctordetails
 * 
 * @author Komaljit.Singh
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
	private final DoctorProcessor doctorProcessor;
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public DoctorController(DoctorProcessor doctorProcessor) {

		this.doctorProcessor = doctorProcessor;
	}

	/**
	 * End-point to save doctor details
	 * 
	 * @param doctorDetail
	 * @return
	 */
	//@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/save")
	public ResponseEntity<Boolean> saveDoctorDetail(@RequestBody final DoctorDetail doctorDetail) {

		logger.info("A request for save doctor detail is in proccess",doctorDetail);
		//doctorDetail.setPassword(bCryptPasswordEncoder.encode(doctorDetail.getPassword()));
		doctorProcessor.saveDoctorDetail(doctorDetail);
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
	
	//@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/get")
	public List<DoctorDetail> getDoctorDetail(@RequestParam int doctorId,String department,int yearOfExp) {

		logger.info("A request for get doctor detail is in proccess");

		return (List<DoctorDetail> )doctorProcessor.getDoctorDetail(doctorId,department,yearOfExp);
	}
	
	//@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/isdoctorvalid")
	public ResponseEntity<Boolean> validateDoctor(@RequestParam String email, String password) {

		logger.info("A request for save doctor detail is in proccess");

		return ResponseEntity.status(HttpStatus.OK).body(doctorProcessor.validateDoctor(email, password));
	}
	
	@GetMapping("/get/appointment/details")
	public List<PatientDetail> getAppointmentDetail(@RequestParam int appointmentStatus,int doctorId) throws ExceptionHandler{
		logger.info("get appointemt details"+doctorId+appointmentStatus);
		
		return doctorProcessor.getAppointmentDetail(appointmentStatus,doctorId);
	}
	
	@PutMapping("/update/appointment/status")
	public ResponseEntity<Boolean> updateAppointmentStatus(@RequestParam int doctorId,int appointmentStatus,int patientId){
		logger.info("update appointment status "+doctorId+appointmentStatus);
		doctorProcessor.updateAppointmentStatus(doctorId,appointmentStatus,patientId);
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
}
