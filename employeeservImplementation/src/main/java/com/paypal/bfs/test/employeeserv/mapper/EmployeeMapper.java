package com.paypal.bfs.test.employeeserv.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.mapstruct.factory.Mappers;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;

@Mapper
public interface EmployeeMapper {
	EmployeeMapper INSTANCE = Mappers.getMapper( EmployeeMapper.class );
	@Mapping(source = "dateOfBirth", dateFormat = "yyyy-mm-dd",target="dateOfBirth")
	EmployeeDao convertDtoToDao(Employee emp);
	@Mapping(target = "dateOfBirth", expression = "java(dateToString(empdao.getDateOfBirth()))")  
	Employee convertDaoToDto(EmployeeDao empdao);
	
	
	default String dateToString(Date dateOfBirth) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        
        return dateFormat.format(dateOfBirth);
    }


	

}
