package com.callor.server;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// "/index", "/" 요청하면 받음
/**
 * Servlet : Server Applet
 * Java 코드를 사용하면 Server 어플리케이션 클래스
 * HttpServlet 클래스를 상속받고, @WebServlet Annotation 을 부착한다
 * doGet(), doPost() method 를 기본적으로 구현한다
 */


@WebServlet( "/index" )
public class IndexServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServelet() {
        super();
    }

    // router.get("/",(req,res) => {})
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String view = "/WEB-INF/views/index.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(view);
		dispatcher.forward(req, res);
		// forward() === render()
		// getRequestDispatcher 를 통해서 view를 만들고
		// "/WEB-INF/views/index.jsp"; 파일을 사용자에게 랜더링 해서 보여줘
		
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// res.send()
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
