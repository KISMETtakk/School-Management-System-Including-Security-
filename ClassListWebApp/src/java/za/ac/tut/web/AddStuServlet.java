package za.ac.tut.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import za.ac.tut.model.bl.StudentFacadeLocal;
import za.ac.tut.model.entity.Student;

@MultipartConfig
public class AddStuServlet extends HttpServlet {

  @EJB StudentFacadeLocal sfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
       Long studNum = Long.parseLong(request.getParameter("stuNum"));
       String name = request.getParameter("name");
       String surname = request.getParameter("surname");
       Integer age = Integer.parseInt(request.getParameter("age"));
       String strGender = request.getParameter("gender");
       Character gender = strGender.charAt(0);
       
       //getPhoto
       Part photo = request.getPart("image");
       InputStream input = photo.getInputStream();
       ByteArrayOutputStream data = new ByteArrayOutputStream();
       byte[] buffer = new byte[4029];
       int readByte;
       
       while((readByte = input.read(buffer)) != -1)
       {
          data.write(buffer, 0, readByte);
       }
       
       byte[] image = data.toByteArray();
       
       String[]  subjects = request.getParameterValues("subjects");
       Date date = new Date();
       
       Student stu = createStudent(studNum,name,surname,age,gender,image,subjects,date);
       sfl.create(stu);
       
       request.setAttribute("name", name);
       request.setAttribute("studNum", studNum);
       
       RequestDispatcher disp = request.getRequestDispatcher("add_outcome.jsp");
       disp.forward(request, response);
       
       
    }

    private Student createStudent(Long studNum, String name, String surname, Integer age, Character gender, byte[] image, String[] subjects, Date date) 
    {
      Student stu = new Student();
      stu.setId(studNum);
      stu.setName(name);
      stu.setSurname(surname);
      stu.setAge(age);
      stu.setGender(gender);
      stu.setImage(image);
      stu.setSubjects(subjects);
      stu.setCreationDate(date);
      
      return stu;
    }



}
