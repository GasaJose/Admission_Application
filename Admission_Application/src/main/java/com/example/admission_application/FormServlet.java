package com.example.admission_application;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.mail.Session;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@WebServlet(name = "FormServlet", value = "/FormServlet")
public class FormServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final Session emailSession = Mailing.configureEmail();
        String fName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String dateOfBirth = request.getParameter("dateOfBirth");

        // validation
        if (fName != null && !fName.isEmpty() &&
                lastName != null && !lastName.isEmpty() &&
                email != null && !email.isEmpty() &&
                phoneNumber != null && !phoneNumber.isEmpty() &&
                dateOfBirth != null && !dateOfBirth.isEmpty()){

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
        out.println("<h3>" + "Student information"+"</h3>");
            out.println("<p>" + "First name:" + fName + "</p>");
            out.println("<p>" + "Last name:" + lastName + "</p>");
            out.println("<p>" + "email:" + email + "</p>");
            out.println("<p>" + "phone number:" + phoneNumber + "</p>");
            out.println("<p>" + "date of birth:" + dateOfBirth + "</p>");
            out.println("</body></html>");

        } else {
            // Some input fields are empty, handle the validation failure
            response.getWriter().println("Please fill in all required fields");
        }
        sendEmail(fName, lastName, email, phoneNumber, dateOfBirth);
    }
    private void sendEmail(String fName, String lastName, String email, String phoneNumber, String dateOfBirth) {
        // Set up properties for the email
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP server
        props.put("mail.smtp.port", "587"); //  SMTP port

        // a Session with the provided properties and Authenticator
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gasanajoseph6@gmail.com", "gVRJkcimD4Mpm2T"); // Replace with your email and password
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gasanajoseph6@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Application Confirmation");
            message.setText("Dear " + fName + "\n\n"
                    + "Thank you for application.\n\n"
                    + "Details:\n"
                    + "Email: " + email + "\n"
                    + "Phone Number: " + phoneNumber + "\n"
                    + "Date of Birth: " + dateOfBirth + "\n"
                    + "Your application has been received. We will get back to you soon.\n\n"
                    + "Best regards,\n"
                    + "Admission Office");

            Transport.send(message);

            System.out.println("sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}