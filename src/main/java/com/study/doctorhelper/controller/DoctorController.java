package com.study.doctorhelper.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.doctorhelper.model.DoctorDetail;
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

	public DoctorController(DoctorProcessor doctorProcessor) {

		this.doctorProcessor = doctorProcessor;
	}

	/**
	 * End-point to save doctor details
	 * 
	 * @param doctorDetail
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Boolean> saveDoctorDetail(@RequestBody final DoctorDetail doctorDetail) {

		logger.info("A request for save doctor detail is in proccess");

		doctorProcessor.saveDoctorDetail(doctorDetail);
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
}
