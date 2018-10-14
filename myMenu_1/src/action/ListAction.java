//メニューの全リストを取得するクラス
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

		//MenuDAOのallListメソッドを呼び出し、menu_listから全メニューの情報を取得
		//配列listへ格納し、セッション属性へ渡す
		MenuDAO dao= new MenuDAO();
		List<Menu> list = dao.allList();

		session.setAttribute("list", list);

		return "menuList.jsp";
	}
}
