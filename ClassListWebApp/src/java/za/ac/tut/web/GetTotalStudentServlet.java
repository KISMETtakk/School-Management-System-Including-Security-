package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentFacadeLocal;


public class GetTotalStudentServlet extends HttpServlet
{
    @EJB
    private StudentFacadeLocal sfl;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
       int totNumStu = sfl.count();
       request.setAttribute("totNumStu", totNumStu);
       RequestDispatcher rd = request.getRequestDispatcher("total_no_stu.jsp");
       rd.forward(request, response);
    }

}
