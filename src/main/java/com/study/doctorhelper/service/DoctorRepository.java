/**
 * 
 */
package com.study.doctorhelper.service;

import java.util.List;

import com.study.doctorhelper.model.DoctorDetail;

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
}
