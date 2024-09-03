package jp.co.sss.crud.bean;

import java.util.Date;

public class EmployeeBean {
	/** 社員ID*/
	private Integer empId;
	/** パスワード*/
	private String empPass;
	/** 社員名*/
	private String empName;
	/** 性別*/
	private Integer gender;
	/** 性別*/
	private String address;
	/** 住所*/
	private Date birthday;
	/** 誕生日*/
	private Integer authority;
	/** 権限*/
	private Integer deptId;
	/** 部署ID*/
	public Integer getEmpId() {
		return empId;
	
	
	}
	/**
	 * @return empPass
	 */
	public String getEmpPass() {
		return empPass;
	}
	/**
	 * @param empPass セットする empPass
	 */
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName セットする empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return gender
	 */
	public Integer getGender() {
		return gender;
	}
	/**
	 * @param gender セットする gender
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return birthday
	 */
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return authority
	 */
	public Integer getAuthority() {
		return authority;
	}
	/**
	 * @param authority セットする authority
	 */
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	/**
	 * @return deptId
	 */
	public Integer getDeptId() {
		return deptId;
	}
	/**
	 * @param deptId セットする deptId
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	/**
	 * @param empId セットする empId
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
}
