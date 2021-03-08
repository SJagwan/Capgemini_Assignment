package com.cg.empmgt.dao;

import com.cg.empmgt.beans.*;
import java.util.*;

public interface IEmployeeDao {
	
    void add(Employee employee) ;
    
    Employee findById(int id); 
   
    void removeById(int id);
    
    List<Employee> findAll();

}
