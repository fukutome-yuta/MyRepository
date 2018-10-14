//ログインの判定クラス
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDAO;
import tool.Action;

public class LoginAction extends Action{
	public String execute(HttpServletRequest request, HttpServletResponse response)throws Exception{

		HttpSession session = request.getSession();

		//受け取ったidとpassをUserDAOのsearchメソッドヘ渡し、ユーザーの判定を行う
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		UserDAO dao = new UserDAO();
		User user = dao.search(id, pass);

		//nullじゃなければUserbeanに格納した情報をセッション属性ヘ渡す
		if(user != null){
			session.setAttribute("user", user);
			return "mainMenu.jsp";
		}

		//nullならloginError画面へ遷移する
		return "loginError.jsp";
	}
}
