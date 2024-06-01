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
import za.ac.tut.model.entity.Student;


public class YoungestStuDe extends HttpServlet {

@EJB
private StudentFacadeLocal sfl;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Student stu = sfl.getYoungestStudent();
        
        request.setAttribute("stu", stu);
        RequestDispatcher rd = request.getRequestDispatcher("young_stu_outcome.jsp");
        rd.forward(request, response);
    }

}
