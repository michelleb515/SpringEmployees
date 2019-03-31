package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
