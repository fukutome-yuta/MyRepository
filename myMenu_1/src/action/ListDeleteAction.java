package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MaterialDAO;
import tool.Action;

public class ListDeleteAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{

		HttpSession session = request.getSession();
		session.removeAttribute("mt");
		session.removeAttribute("mtlist");
		session.removeAttribute("menus");
		session.removeAttribute("list");

		MaterialDAO dao= new MaterialDAO();
		dao.delete();
		return "mainMenu.jsp";
	}
}
