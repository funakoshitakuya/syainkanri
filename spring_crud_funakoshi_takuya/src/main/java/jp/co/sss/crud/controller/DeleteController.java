package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.mapper.EmployeeMapper;

@Controller
public class DeleteController {
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 削除ボタンを押した後id検索をし、そのレコードを出力するコントローラー。
	 * @param empId
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/delete/{empId}", method = RequestMethod.GET)
	public String delete(@PathVariable int empId, EmployeeForm employeeForm, Model model) {
		// 取得したemp_idで主キー検索し、レコードをエンティティに格納。
		Employee employee = employeeMapper.getOne(employeeForm.getEmpId());
		// Beanをリクエストスコープに保存
		model.addAttribute("employees", employee);
		return "delete/delete_check";
	}

	/**
	 * 削除コントローラー。
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/delete/complete", method = RequestMethod.POST)
	public String registComplete1(EmployeeForm employeeForm, Model model) {
		// Employeeエンティティの生成
		Employee employee = new Employee();
		// Form内のレコードをemployeeに格納。
		employee.setEmpId(employeeForm.getEmpId());
		employee.setEmpPass(employeeForm.getEmpPass());
		employee.setEmpName(employeeForm.getEmpName());
		employee.setGender(employeeForm.getGender());
		employee.setAddress(employeeForm.getAddress());
		employee.setBirthday(employeeForm.getBirthday());
		employee.setAuthority(employeeForm.getAuthority());
		employee.setDeptId(employeeForm.getDeptId());
		// employeeMapperを利用してdeleteメソッドを実行。
		employeeMapper.delete(employee);
		// Beanをリクエストスコープに保存。
		model.addAttribute("employees", employee);
		return "delete/delete_complete";
	}
}
