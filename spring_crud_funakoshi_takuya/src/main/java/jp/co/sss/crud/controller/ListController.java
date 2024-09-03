package jp.co.sss.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.EmployeeForm;
import jp.co.sss.crud.mapper.EmployeeMapper;

@Controller
public class ListController {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	HttpSession session;

	/**
	 * 部署名検索。
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/list/deptId", method = RequestMethod.GET)
	public String deptSeach(EmployeeForm employeeForm, Model model) {
		// 部署ID検索し、レコードをエンティティに格納。
		List<Employee> employee = employeeMapper.getDept(employeeForm.getDeptId());
		// 検索した値をemployeeに保存。
		model.addAttribute("employees", employee);
		return "list/list";
	}

	/**
	 * 社員名称検索。
	 * @param employeeForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/list/empName", method = RequestMethod.GET)
	public String enpseach(EmployeeForm employeeForm, Model model) {
		// 入力された値でLIKE検索。
		List<Employee> employee = employeeMapper.enpNameSeach(employeeForm.getEmpName());
		// 検索結果が1つでもある場合、検索した値をモデルに保存。
		model.addAttribute("employees", employee);
		return "list/list";

	}

	/**
	 * 初期画面に戻る。
	 * @param loginForm
	 * @return
	 */
	@RequestMapping(path = "/home")
	public String home(Model model) {
		// 保存していた値で全件検索。
		model.addAttribute("employees", employeeMapper.findAll());
		return "list/list";
	}
}
