import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyResultServlet
 */
@WebServlet("/MyResultServlet")
public class MyResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// TODO Auto-generated method stub
	PrintWriter out = response.getWriter();
	int  rno = Integer.parseInt(request.getParameter("id"));
	try {
		Class.forName("oracle.jdbc.OracleDriver");

		Connection con = DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1521:xe","system","shiva");
		PreparedStatement pst = con.prepareStatement
				("select * from eceresult where id = ?");
		pst.setInt(1, rno);
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		 out.print(rs.getInt(1)+"---"+rs.getString(2));
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		out.print(e);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		out.print(e) 	 	;
	}
	
	
		//	response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
