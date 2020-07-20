package com.study.doctorhelper.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.study.doctorhelper.model.Address;
import com.study.doctorhelper.model.DoctorDetail;
import com.study.doctorhelper.model.Gender;

import ch.qos.logback.core.net.SyslogOutputStream;

public class DoctorMapper implements RowMapper{

	@Override
	public DoctorDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DoctorDetail doctor = new DoctorDetail();
		doctor.setDoctorId(rs.getInt("doctorid"));
		doctor.setDoctorName(rs.getString("name"));
		doctor.setMobileNo(rs.getString("phone_no"));
		doctor.setEmail(rs.getString("email"));
		doctor.setDepartment(rs.getString("department"));
		doctor.setQualification(rs.getString("qualification"));
		doctor.setSpecialist(rs.getString("specialist"));
		doctor.setYearOfExperience(rs.getInt("year_of_experirence"));
		LocalDateTime localDateTime = rs.getTimestamp("dob").toLocalDateTime();
		ZonedDateTime date = localDateTime.atZone(ZoneId.systemDefault());
		doctor.setDob(date);
		doctor.setPassword("password");
		String gender = rs.getString("gender");
		if(gender.equals("MALE"))
			doctor.setGender(Gender.MALE);
		else
			doctor.setGender(Gender.FEMALE);
		String[] address = rs.getString("address").split(",");
		Address addressObj = new Address("",address[0],address[1],Integer.parseInt(address[3]),address[2]);
		doctor.setAddress(addressObj);
		
		return doctor;
	}

}
