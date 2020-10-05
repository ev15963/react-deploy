

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.controller.ActionFactory;
import com.lsw.controller.action.Action;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		//request영역에 있는 command 파라미터 값을 command란는 이름의 String 으로 저장
		
		System.out.println("BoardServlet 에서 요청을 받음을 확인"+command);
		//command값이 무엇인지 콘솔창에서 확인
		
		ActionFactory af = ActionFactory.getInstance();
		//ActionFactory의 getInstance에는 return instance가 들어있다
		//instance는 ActionFactory 객체화한 싱글톤
		
		Action action = af.getAction(command);
		//ActionFactory 클래스에서 불러온
		//Action 클래스의 getAction의 (String command)를 인자로 받던 것을 Action action에 담는다.
		
		if(action != null) { //만일 action이 null이 아닐때 (action에 command 값이 들어와 있을때)
			action.execute(request, response); //action의 request와 response를 담아서 실행한다.
			//execute - SQL문이 무엇인지 모를때사용
			//반환은 true 이면 Resultset객체에, false이면 결과가 없거나 갱신된 행의 수의 경우
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //request 영역에서 받은 것을 UTF-8로 인코딩 해준후
		doGet(request, response); //doget으로 보내서 doget메소드와 동일하게 사용
	}

}
