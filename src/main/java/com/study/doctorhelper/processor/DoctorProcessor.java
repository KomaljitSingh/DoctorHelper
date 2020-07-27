package com.study.doctorhelper.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.doctorhelper.controller.DoctorController;
import com.study.doctorhelper.exception.ExceptionHandler;
import com.study.doctorhelper.model.DoctorDetail;
import com.study.doctorhelper.model.PatientDetail;
import com.study.doctorhelper.service.DoctorRepository;

/**
 * This class is built to maintain all the doctor detail processing
 * orchestration and business logic. It represents the internal API for
 * doctor-helper service.
 *
 * @author Komaljit.Singh
 *
 */
@Service
public class DoctorProcessor {

	private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorRepository doctorRepository;

	public DoctorProcessor(DoctorRepository doctorRepository) {

		this.doctorRepository = doctorRepository;
	}

	/**
	 * Method to process the doctor details to save.
	 * 
	 * @param doctorDetail
	 */
	public void saveDoctorDetail(DoctorDetail doctorDetail) {

		logger.info("save doctor details is called with request as: {} ", doctorDetail);

		doctorRepository.saveDoctorDetails(doctorDetail);
	}

	public List<DoctorDetail> getDoctorDetail(int doctorId,String department,int yearOfExp){
			

		logger.info("save doctor details is called with request as: {} ");

		return (List<DoctorDetail>) doctorRepository.getDoctorDetail(doctorId, department, yearOfExp);
	}

	public boolean validateDoctor(String email, String password) {

		logger.info("validate doctor service is called ");

		return doctorRepository.isValidDocotor(email, password);
	}

	
	public List<PatientDetail> getAppointmentDetail(int appointmentStatus,int doctorId) throws ExceptionHandler{
		logger.info("get appointment details for doctor"+appointmentStatus,doctorId);
		return doctorRepository.getAppointmentDetail(appointmentStatus,doctorId);
	}
	
	public void updateAppointmentStatus(int doctorId,int appointmentStatus,int patientId){
		logger.info("update appointmennt status");
		doctorRepository.updateAppointmentStatus(doctorId,appointmentStatus,patientId);
	}

}
