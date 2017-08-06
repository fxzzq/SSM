package com.xzq.curd.service;

import com.xzq.curd.bean.Employee;
import com.xzq.curd.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

/*自动装配service的逻辑业务*/
    @Autowired
    EmployeeMapper employeeMapper;
    /*查询所有员工*/
    public List<Employee> getALL(){
        return employeeMapper.selectByExampleWithDept(null);

    }

}
