package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Action;

/**
 * JSPから渡されたパスをリネームし、各アクションのexecuteメソッドの処理結果をJSPへフォワード
 */
@WebServlet(urlPatterns= {"*.action"})
public class FrontController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			//サーブレットのパスを取得し、「パッケージ名.クラス名」の形にリネームし
			String path = request.getServletPath().substring(1);
			String name = path.replace(".a", "A").replace('/', '.');
			String name1 = "action." + name;
			//該当クラスのインスタンスを生成
			Action action = (Action)Class.forName(name1).newInstance();
			//該当actionクラスのexecuteメソッドの処理結果(結果を表示するJSPのパス)をurlへ格納
			String url = action.execute(request, response);
			//該当JSPへフォワード
			request.getRequestDispatcher(url).forward(request, response);
		}catch (Exception e) {
			e.printStackTrace(out);
		}
	}
	/**
	 * GETリクエストで呼び出された場合はPOSTメソッドを呼び出す
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}