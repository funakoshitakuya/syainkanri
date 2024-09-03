package jp.co.sss.crud.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginForm {
	
	/**ユーザーIDがNULLになっていないかのチェック。*/
	@NotNull
	/**Maxが99999以下(5桁以下)であるか。*/
	@Max(value = 99999)
	/** ユーザーID*/
	private Integer empId;
	/**NULL、空文字、空白のみではないか*/
	@NotBlank
	/**16文字以下であるか*/
	@Size(max = 16)
	/** パスワード*/
	private String empPass;

	/**
	 * 社員IDの取得
	 *
	 * @return 社員ID
	 */
	public Integer getEmpId() {
		return empId;
	}

	/**
	 * 社員IDのセット
	 *
	 * @param empId 社員ID
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	/**
	 * パスワードの取得
	 *
	 * @return パスワード
	 */
	public String getEmpPass() {
		return empPass;
	}

	/**
	 * パスワードのセット
	 *
	 * @param empPass パスワード
	 */
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
}
