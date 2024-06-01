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


public class PerServlet extends HttpServlet
{
    @EJB
    private StudentFacadeLocal sfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String optionStr = request.getParameter("option");
        Character gender = optionStr.charAt(0);
        String genderStr = "Male";
        
        if(gender == 'F')
        {
            genderStr = "Female";
        }
        
        Double num = sfl.percentagePerGender(gender);
        request.setAttribute("num", num);
        request.setAttribute("genderStr", genderStr);
        
        RequestDispatcher rd = request.getRequestDispatcher("per_out_come.jsp");
        rd.forward(request, response);
    }
}
