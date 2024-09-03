package jp.co.sss.crud.entity;

public class Department {
	/** 部署ID*/
	private Integer deptId;
	/** 部署名*/
	private String deptName;
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
}
