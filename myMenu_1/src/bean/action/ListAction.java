package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Menu;
import dao.MenuDAO;
import tool.Action;

public class ListAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{

		HttpSession session = request.getSession();

		MenuDAO dao= new MenuDAO();
		List<Menu> list = dao.allList();

		session.setAttribute("list", list);

		return "menuList.jsp";
	}
}