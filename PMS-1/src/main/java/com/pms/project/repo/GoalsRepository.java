package com.pms.project.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.project.entity.Employee;
import com.pms.project.entity.Goal;

public interface GoalsRepository extends JpaRepository<Goal, Long> {

	@Query("select g from Goal g where g.employee.id=?1")
	List<Goal> findByEmployeeId(long employee_id);

	@Query("select g.employee from Goal g where g.id=?1")
	Optional<Employee> findEmployeeByGoal(long id);

	@Query("select g from Goal g where g.manager_id=?1")
	List<Goal> findByManager_id(Long manager_id);

	@Query("select g from Goal g where g.hr_id=?1")
	List<Goal> findByHr_id(Long hr_id);

//	Long findEmployeeIdByGoal(Long id);

}
