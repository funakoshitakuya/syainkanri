package jp.co.sss.crud.entity;
/**
 * エンティティ
 */
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Employee {
	/** 社員ID */
	private Integer empId;

	/** パスワード */
	@NotBlank
	@Size(min = 1, max = 16)
	private String empPass;

	/** 社員名 */
	@NotBlank
	@Size(min = 1, max = 30)
	private String empName;

	/** 性別 */
	private Integer gender;

	/** 住所 */
	@NotBlank
	@Size(min = 1, max = 60)
	private String address;

	/** 生年月日 */
	@NotNull
	private Date birthday;

	/** 権限 */
	private Integer authority;

	/** 部署ID */
	private Integer deptId;

	/** 部署名*/
	private String deptName;
	
	/**
	 * @return empId
	 */
	public Integer getEmpId() {
		return empId;
	}
	/**
	 * @param empId セットする empId
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
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
	 * @return deptName
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * @param deptName セットする deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

}
