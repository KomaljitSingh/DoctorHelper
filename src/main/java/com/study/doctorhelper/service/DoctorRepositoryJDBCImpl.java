/**
 * 
 */
package com.study.doctorhelper.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.doctorhelper.exception.ExceptionHandler;
import com.study.doctorhelper.exception.ExceptionType;
import com.study.doctorhelper.model.Address;
import com.study.doctorhelper.model.DoctorDetail;
import com.study.doctorhelper.model.PatientDetail;

/**
 * This class is used to interact with Doctor DataBase for DoctorDetails
 * 
 * @author Komaljit.Singh
 */
@Repository
public class DoctorRepositoryJDBCImpl implements DoctorRepository {

	private static final Logger logger = LoggerFactory.getLogger(DoctorRepositoryJDBCImpl.class);
	private JdbcTemplate jdbcTemplate;

	private static final String DATE_FORMAT = "yyyy:MM:dd:HH:mm:ss";

	@Autowired
	public DoctorRepositoryJDBCImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saveDoctorDetails(DoctorDetail doctorDetail) {

		// insert query to save doctor detail
		String doctorInsertQuery = "INSERT INTO DOCTOR (DOCTORID,NAME,PHONE_NO,EMAIL,DEPARTMENT,"
				+ "QUALIFICATION,SPECIALIST,YEAR_OF_EXPERIRENCE,DOB,PASSWORD,GENDER,STATUS,ADDRESS)"
				+ "VALUES (?,?,?,?,?,?,?,?,TO_DATE(?,'YYYY:MM:dd:HH24:MI:SS'),?,?,?,?)";

		Address addressDetail = doctorDetail.getAddress();
		String address = addressDetail.getCity() + "," + addressDetail.getState() + "," + addressDetail.getCountry()
				+ "," + addressDetail.getPincode();
		List<Object> sqlParameters = new ArrayList<>();

		sqlParameters.add(doctorDetail.getDoctorId());
		sqlParameters.add(doctorDetail.getDoctorName());
		sqlParameters.add(doctorDetail.getMobileNo());
		sqlParameters.add(doctorDetail.getEmail());
		sqlParameters.add(doctorDetail.getDepartment());
		sqlParameters.add(doctorDetail.getQualification());
		sqlParameters.add(doctorDetail.getSpecialist());
		sqlParameters.add(doctorDetail.getYearOfExperience());
		sqlParameters.add(doctorDetail.getDob().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
		sqlParameters.add(doctorDetail.getPassword());
		sqlParameters.add(doctorDetail.getGender().name());
		sqlParameters.add(doctorDetail.getStatus());
		sqlParameters.add(address);

		logger.debug("Executing doctor insert query: {} with params : [{}]", doctorInsertQuery,
				sqlParameters.toArray());

		jdbcTemplate.update(doctorInsertQuery, sqlParameters.toArray());
	}

	public List<DoctorDetail> getDoctorDetail(int doctorId, String department, int yearOfExp) {
		String doctorSelectQuery = "SELECT DOCTORID,NAME,PHONE_NO,EMAIL,DEPARTMENT,"
				+ "QUALIFICATION,SPECIALIST,YEAR_OF_EXPERIRENCE,DOB,PASSWORD,GENDER,STATUS,ADDRESS FROM DOCTOR"
				+ " WHERE DOCTORID = ? AND DEPARTMENT = ? AND YEAR_OF_EXPERIRENCE = ? ";

		List<Object> sqlParameters = new ArrayList<>();
		sqlParameters.add(doctorId);
		sqlParameters.add(department);
		sqlParameters.add(yearOfExp);

		logger.debug("Executing doctor insert query: {} with params : [{}]", doctorSelectQuery,
				sqlParameters.toArray());

		List<DoctorDetail> doctorData = jdbcTemplate.query(doctorSelectQuery, new Object[] { sqlParameters.toArray() },
				new DoctorMapper());
		return doctorData;
	}
	
	
	public List<PatientDetail> getAppointmentDetail(int appointmentStatus,int doctorId) throws ExceptionHandler{
		List<PatientDetail> patientData = new ArrayList<PatientDetail>();
		try{
			
			String getAppointmentQuery = "SELECT P.PATIENTID,P.NAME,P.PHONE_NO,P.EMAIL,"
				+ "P.DOB,P.PASSWORD,P.GENDER,P.STATUS,P.ADDRESS,A.APPOINTMENTID,A.APPOINTMENT_STATUS,A.APPOINTMENT_DATE FROM PATIENT P INNER JOIN APPOINTMENT A"
				+ " ON  A.PATIENTID = P.PATIENTID WHERE A.APPOINTMENT_STATUS = ? AND A.DOCTORID =  ?  ";
		
		logger.debug("Executing doctor get appointment query: {} with params : [{}]", appointmentStatus,
				doctorId);
		
		 patientData  = jdbcTemplate.query(getAppointmentQuery,new Object[]{appointmentStatus,doctorId},new PatientMapper());
		}catch(Exception err){
			throw new ExceptionHandler(ExceptionType.DBEXCEPTION.toString(),err);
		}
		return patientData;
	}

	@Override

	public boolean isValidDocotor(String email, String password) {
		String validateDoctorSelectQuery = "SELECT * FROM DOCTOR WHERE EMAIL = ? AND PASSWORD = ? ";

		List<Object> sqlParameters = new ArrayList<>();
		sqlParameters.add(email);
		sqlParameters.add(password);

		logger.debug("Executing doctor insert query: {} with params : [{}]", validateDoctorSelectQuery,
				sqlParameters.toArray());

		DoctorDetail doctorData = (DoctorDetail) jdbcTemplate.queryForObject(validateDoctorSelectQuery,new Object[] { email, password},
				new DoctorMapper());
		boolean isValid= doctorData!=null;
		return isValid;
	}

	public void updateAppointmentStatus(int doctorId, int appointmentStatus,int patientId) {
		// TODO Auto-generated method stub
		String updateAppointmentQuery = " UPDATE APPOINTMENT SET APPOINTMENT_STATUS = ? WHERE DOCTORID = ? AND PATIENTID = ?";
		List<Object> sqlParameters = new ArrayList<>();
		sqlParameters.add(appointmentStatus);
		sqlParameters.add(doctorId);
		sqlParameters.add(patientId);
		jdbcTemplate.update(updateAppointmentQuery,sqlParameters.toArray());

	}
}
