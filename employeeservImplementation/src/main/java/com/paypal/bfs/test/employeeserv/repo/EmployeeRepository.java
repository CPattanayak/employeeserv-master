package com.paypal.bfs.test.employeeserv.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.employeeserv.dao.EmployeeDao;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDao, Integer>{

}
