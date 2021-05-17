package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.customexception.EmployeeNotfoundException;
import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
import com.paypal.bfs.test.employeeserv.mapper.EmployeeMapper;
import com.paypal.bfs.test.employeeserv.repo.EmployeeRepository;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {
	@Autowired
	private EmployeeRepository employeeRepository;
    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
    	Optional<EmployeeDao> employee = employeeRepository.findById(Integer.valueOf(id));
    	if (!employee.isPresent())
    	      throw new EmployeeNotfoundException("id-" + id);;
    	Employee employeeRes = EmployeeMapper.INSTANCE.convertDaoToDto(employee.get());
        return new ResponseEntity<>(employeeRes, HttpStatus.OK);
    }

	@Override
	public ResponseEntity<Employee> saveEmployee(Employee employee) {
		EmployeeDao employeeDao = EmployeeMapper.INSTANCE.convertDtoToDao(employee);
		employeeDao=employeeRepository.save(employeeDao);
		Employee returnedEmp = EmployeeMapper.INSTANCE.convertDaoToDto(employeeDao);

		return new ResponseEntity<>(returnedEmp, HttpStatus.OK);
		
	}
}
