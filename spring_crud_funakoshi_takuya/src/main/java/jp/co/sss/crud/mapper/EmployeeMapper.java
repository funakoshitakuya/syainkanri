package jp.co.sss.crud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.sss.crud.entity.Employee;

@Mapper
public interface EmployeeMapper {
	/**
	 * 全件検索。
	 * @return
	 */
	List<Employee> findAll();

	/**
	 * empIdでの条件検索。
	 * @param empId
	 * @return
	 */
	Employee getOne(@Param("empId") int empId);

	/**
	 * deptIdでの条件検索。
	 * @param deptId
	 * @return
	 */
	List<Employee> getDept(@Param("deptId") int deptId);

	/**
	 * 社員名検索。
	 * @param empName
	 * @return
	 */
	List<Employee> enpNameSeach(@Param("empName") String empName);

	/**
	 * 登録メソッド。
	 * @param fruits_season
	 */
	int insert(Employee employee);

	/**
	 * 更新メソッド。
	 * @param fruits_season
	 */
	int update(Employee employee);

	/**
	 * 削除メソッド。
	 * @param fruits_season
	 */
	int delete(Employee employee);

}
