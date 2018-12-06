import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchBySalary")
public class SearchBySalary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		double min = Double.parseDouble(request.getParameter("minSalary"));
		double max = Double.parseDouble(request.getParameter("maxSalary"));
		List<Employee> employeeList = EmployeeServiceImpl.getInstance().searchEmployeeBySalary(min, max);
		pw.write("<html><body><table border = '1'>");
		pw.write("<tr><td>Empid</td><td>EmpName</td><td>Salary</td></tr>");
		for(Employee emp: employeeList ) {
			pw.write("<tr><td>"+emp.getEmpID()+"</td><td>"+emp.getName()+"</td><td>"+emp.getSalary()+"</td></tr>");
		}
		pw.write("</table></body></html>");
	}
}
