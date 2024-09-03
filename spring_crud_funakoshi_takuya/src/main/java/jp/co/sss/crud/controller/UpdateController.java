package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.mapper.EmployeeMapper;
import jp.co.sss.crud.util.Constant;

@Controller
public class UpdateController {
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 入力画面を表示するためのメソッド
	 * updateInput()
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/update/input", method = RequestMethod.GET)
	public String updateSession(int empId, EmployeeForm employeeForm, Model model) {
		// emp_idで主キー検索し、レコードをエンティティに格納。
		Employee employee = employeeMapper.getOne(employeeForm.getEmpId());
		// その値をモデルに保存。
		// 入力された値の確認。
		employeeForm.setEmpId(employee.getEmpId());
		employeeForm.setEmpName(employee.getEmpName());
		employeeForm.setGender(employee.getGender());
		employeeForm.setAddress(employee.getAddress());
		employeeForm.setBirthday(employee.getBirthday());
		employeeForm.setAuthority(employee.getAuthority());
		employeeForm.setDeptId(employee.getDeptId());
		employeeForm.setGender(Constant.DEFAULT_GENDER);
		employeeForm.setAuthority(Constant.DEFAULT_AUTHORITY);
		return "update/update_input";
	}

	/**
	 * 入力画面を表示するためのメソッド
	 * updateInput()
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/update/{empId}", method = RequestMethod.POST)
	public String update(@PathVariable int empId, @ModelAttribute EmployeeForm employeeForm, Model model) {
		// emp_idで主キー検索し、レコードをエンティティに格納。
		Employee employee = employeeMapper.getOne(employeeForm.getEmpId());
		// その値をモデルに保存。
		// 入力された値の確認。
		employeeForm.setEmpId(employee.getEmpId());
		employeeForm.setEmpName(employee.getEmpName());
		employeeForm.setGender(employee.getGender());
		employeeForm.setAddress(employee.getAddress());
		employeeForm.setBirthday(employee.getBirthday());
		employeeForm.setAuthority(employee.getAuthority());
		employeeForm.setDeptId(employee.getDeptId());
		return "update/update_input";
	}

	/**
	 * 変更するレコードの確認。
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/update/input", method = RequestMethod.POST)
	public String updateInput(@Valid @ModelAttribute EmployeeForm employeeForm,
		// 入力チェック
		BindingResult result, Model model) {
		// 結果がエラーの場合
		if (result.hasErrors()) {
			// update_inputHTMLに画面遷移。
			return "update/update_input";

		} else {
			Employee employee = new Employee();
			// エンティティのオブジェクト生成
			employee.setEmpId(employeeForm.getEmpId());
			employee.setEmpPass(employeeForm.getEmpPass());
			employee.setEmpName(employeeForm.getEmpName());
			employee.setGender(employeeForm.getGender());
			employee.setAddress(employeeForm.getAddress());
			employee.setBirthday(employeeForm.getBirthday());
			employee.setAuthority(employeeForm.getAuthority());
			employee.setDeptId(employeeForm.getDeptId());
			// 入力された値の確認。
			model.addAttribute("employees", employee);
			// Beanをリクエストスコープに保存。
			return "update/update_check";
			// update_checkHTMLに画面遷移。
		}
	}

	/**
	 * 更新の実行。
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/update/complete", method = RequestMethod.POST)
	public String registComplete1(EmployeeForm employeeForm, Model model) {
		// employeeエンティティの生成
		Employee employee = new Employee();
		// employeeエンティティに入力された値(employeeFormの内容)を格納。
		employee.setEmpId(employeeForm.getEmpId());
		employee.setEmpPass(employeeForm.getEmpPass());
		employee.setEmpName(employeeForm.getEmpName());
		employee.setGender(employeeForm.getGender());
		employee.setAddress(employeeForm.getAddress());
		employee.setBirthday(employeeForm.getBirthday());
		employee.setAuthority(employeeForm.getAuthority());
		employee.setDeptId(employeeForm.getDeptId());
		// FruitsSeasonMapperを利用してテーブルの該当レコードを更新。
		employeeMapper.update(employee);
		// Beanをリクエストスコープに保存。
		model.addAttribute("employees", employee);
		// update_completeHTMLへ画面遷移。
		return "update/update_complete";
	}
}
