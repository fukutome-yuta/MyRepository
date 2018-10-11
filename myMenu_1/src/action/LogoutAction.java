package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{

		HttpSession session = request.getSession();

		session.removeAttribute("user");
		System.out.println("セッションを削除しました");
		return "logout.jsp";
	}
}
