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


public class FindStudentServlet extends HttpServlet 
{
    @EJB
    private StudentFacadeLocal sfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String idNoStr = request.getParameter("idNo");
        Long idNo = Long.parseLong(idNoStr);
        String url = "";
        
        if(idNo == null)
        {
            url = "not_found.jsp";
        }
        else
        {
            url = "find_outcome.jsp";
        }
        
        Student stu = sfl.find(idNo);
        
        request.setAttribute("idNo", idNo);
        request.setAttribute("stu", stu);
        
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
