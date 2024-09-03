package jp.co.sss.crud.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.mapper.EmployeeMapper;

@Controller
public class IndexController {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	HttpSession session;

	/**
	 * ログインコントローラー。
	 * @param loginForm
	 * @return
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute LoginForm loginForm) {
		// スレッドの破棄。
		session.invalidate();
		return "index";
	}

	/**
	 * ログインコントローラー。
	 * @param loginForm
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// 入力チェックエラーの表示。
			return "index";
		}

		// idで主キー検索し、レコードをエンティティに格納。
		Employee employee = employeeMapper.getOne(loginForm.getEmpId());
		if (Objects.nonNull(employee)) {
			// もし検索結果がnullでなかった場合。
			if (employee.getEmpPass().equals(loginForm.getEmpPass())) {
				// もしデータベースと入力したパスワードがあっている場合。
				model.addAttribute("employees", employeeMapper.findAll());
				// 全件検索。
				session.setAttribute("user", employee);
				// sessionでログイン情報を保持。
				return "list/list";
				
			}
		} else {
			model.addAttribute("errMessage", "社員ID、またはパスワードが間違っています。");
			return "index";
			// それ以外の処理

		}
		return "index";
		// それ以外の処理
	}
}
