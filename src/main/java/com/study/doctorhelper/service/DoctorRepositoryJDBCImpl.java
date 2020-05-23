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

import com.study.doctorhelper.model.DoctorDetail;

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
				+ "VALUES (?,?,?,?,?,?,?,?,TO_DATE('2020:05:23:16:35:30','YYYY:MM:dd:HH24:MI:SS'),?,?,?,?)";
		
		List<Object> sqlParameters = new ArrayList<>();
		
		sqlParameters.add(1);
		sqlParameters.add("demo");
		sqlParameters.add("demo");
		sqlParameters.add("demo");
		sqlParameters.add("demo");
		sqlParameters.add("demo");
		sqlParameters.add("demo");
		sqlParameters.add(1);
		sqlParameters.add("demo");
		sqlParameters.add('m');
		sqlParameters.add(1);
		sqlParameters.add("demo");
		for(Object i:sqlParameters.toArray()){
			System.out.println(i);
		}
		 logger.debug("Executing doctor insert query: {} with params : [{}]", doctorInsertQuery, sqlParameters.toArray());

		jdbcTemplate.update(doctorInsertQuery, sqlParameters.toArray());
	}

}
