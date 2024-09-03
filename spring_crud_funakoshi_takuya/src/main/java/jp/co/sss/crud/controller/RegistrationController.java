package jp.co.sss.crud.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.crud.bean.EmployeeBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.mapper.EmployeeMapper;
import jp.co.sss.crud.util.Constant;

@Controller
public class RegistrationController {
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 登録初期画面の表示。
	 * @return
	 */
	@GetMapping("/regist/input")
	public String registInput(@ModelAttribute EmployeeForm employeeForm) {
		employeeForm.setGender(Constant.DEFAULT_GENDER);
		employeeForm.setAuthority(Constant.DEFAULT_AUTHORITY);
		return "regist/regist_input";
	}

	/**
	 * 登録内容のチェック。
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/regist/check", method = RequestMethod.POST)
	public String registCheck(@Valid @ModelAttribute EmployeeForm employeeForm, BindingResult result, Model model) {
		// 結果がエラーの場合
		if (result.hasErrors()) {
			return "update/update_input";

		} else {
			// エンティティの生成
			Employee employee = new Employee();
			// エンティティに入力された値(employeeFormの内容)を格納。
			employee.setEmpPass(employeeForm.getEmpPass());
			employee.setEmpName(employeeForm.getEmpName());
			employee.setGender(employeeForm.getGender());
			employee.setAddress(employeeForm.getAddress());
			employee.setBirthday(employeeForm.getBirthday());
			employee.setAuthority(employeeForm.getAuthority());
			employee.setDeptId(employeeForm.getDeptId());
			// EmployeeBeanのオブジェクトを生成 
			EmployeeBean employeeBean = new EmployeeBean();
			// 登録結果(employeeエンティティ)をemployeeBeanにコピー。
			BeanUtils.copyProperties(employee, employeeBean);
			// Beanをリクエストスコープに保存。
			model.addAttribute("employees", employeeBean);

			return "regist/regist_check";
		}
	}

	/**
	 * 登録処理。
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/regist/regist_complete", method = RequestMethod.POST)
	public String createComplete(EmployeeForm employeeForm, Model model) {
		// エンティティの生成
		Employee employee = new Employee();
		// エンティティに入力された値(employeeForm の内容)を格納。
		employee.setEmpPass(employeeForm.getEmpPass());
		employee.setEmpName(employeeForm.getEmpName());
		employee.setGender(employeeForm.getGender());
		employee.setAddress(employeeForm.getAddress());
		employee.setBirthday(employeeForm.getBirthday());
		employee.setAuthority(employeeForm.getAuthority());
		employee.setDeptId(employeeForm.getDeptId());
		// Mapperを利用してinsertメソッドを実行。
		employeeMapper.insert(employee);
		// EmployeeBeanのオブジェクトを生成。
		EmployeeBean employeeBean = new EmployeeBean();
		// 登録結果(FruitsSeason エンティティ)をemployeeBeanのオブジェクトにコピー。
		BeanUtils.copyProperties(employee, employeeBean);
		// JavaBeanのオブジェクトをリクエストスコープに保存。
		model.addAttribute("employees", employeeBean);

		return "regist/regist_complete";
	}
}
