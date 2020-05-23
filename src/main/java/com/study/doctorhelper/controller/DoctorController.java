package com.study.doctorhelper.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.doctorhelper.processor.DoctorProcessor;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

	private final DoctorProcessor doctorProcessor;

	public DoctorController(DoctorProcessor doctorProcessor) {

		this.doctorProcessor = doctorProcessor;
	}
	
	 @PostMapping("/save")
	public void demo() {
		
		doctorProcessor.testRepo();
	}
}
