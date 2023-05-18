
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement ps;
    RequestDispatcher dispatcher = null;   
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String uproject = request.getParameter("project");
		String umessage = request.getParameter("message");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Contactme", "root", "V2169@gpatil");
			ps = con.prepareStatement("insert into users(uname, uemail, uproject, umessage) values(?, ?, ?, ?)");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(4, umessage);
			
			int row = ps.executeUpdate();
			
            if(row > 0){
                PrintWriter pw = resp.getWriter();
		        pw.println(name + " Welcome !!");
		        pw.println(" I will contact you soon !!");
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
