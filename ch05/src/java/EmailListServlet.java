//package murach.email;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import murach.business.User; 

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        String url = "/index.html";

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("join")) {
            url = "/index.html";
        } 
        else if (action.equals("add")) {
            // lấy tất cả parameter từ form
            String firstName   = request.getParameter("firstName");
            String lastName    = request.getParameter("lastName");
            String email       = request.getParameter("email");
            String gender      = request.getParameter("gender");
            String dob         = request.getParameter("dateOfBirth");
            String heardFrom   = request.getParameter("heardFrom");
            String wantsUpdates= request.getParameter("wantsUpdates");

            // tạo User object và gán giá trị
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setGender(gender);
            user.setDateOfBirth(dob);
            user.setHeardFrom(heardFrom);
            user.setWantsUpdates(wantsUpdates);

            // validation
            String message;
            if (firstName == null || lastName == null || email == null ||
                firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/index.html";
            } else {
                message = "";
                url = "/thanks.jsp";
            }

            // đưa dữ liệu sang JSP
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
