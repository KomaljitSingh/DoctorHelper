/**
 * 
 */
package com.study.doctorhelper.service;

import java.util.List;

import com.study.doctorhelper.exception.ExceptionHandler;
import com.study.doctorhelper.model.DoctorDetail;
import com.study.doctorhelper.model.PatientDetail;

/**
 * Interface to DoctorRepositoryJDBCImpl service end point. This interface provides the
 * necessary methods to communicate with Doctor DB.
 * 
 * @author Komaljit.Singh
 */
public interface DoctorRepository {

	/**
	 * Method to save Doctor Detail into DoctorDB
	 * 
	 * @param doctorDetail
	 */
	public void saveDoctorDetails(DoctorDetail doctorDetail);
	
	public List<DoctorDetail> getDoctorDetail(int doctorId,String department,int yearOfExp);
	
	public boolean isValidDocotor(String email, String password);

	public List<PatientDetail> getAppointmentDetail(int appointmentStatus,int doctorId) throws ExceptionHandler;
	
	public void updateAppointmentStatus(int doctorId,int appointmentStatus,int patientId);

}
