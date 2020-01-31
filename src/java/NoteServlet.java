/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 787900
 */
public class NoteServlet extends HttpServlet {
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String edit = request.getParameter("edit");
        if(edit!=null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        else
        {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line ;
            List<String>   temps = new ArrayList<String>();
            while((line = br.readLine())!= null)       
        {
            temps.add(line);
            System.out.println(temps.get(0)); 
             }
            request.setAttribute("title", temps.get(0));
            for(int i=1;i<temps.size();i++){
              request.setAttribute("content", temps.get(i));
             }
         
         //   System.out.println("View Mode");
             getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
      //  processRequest(request, response);
//         try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet NoteServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet NoteServlet at " + request.getContextPath() + "</h1>");
//            out.println("<h1>[GET]</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         System.out.println("Post Request:");
         String edit = request.getParameter("edit");
         
         if(edit!=null){
              System.out.println("edit" +edit);
        
         
         String title = request.getParameter("title");
         String contents = request.getParameter("contents");
             
         String path = getServletContext().getRealPath("/WEB-INF/note.txt");
         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false))); 
         pw.write(title);
         pw.write(contents);
         
       
             
         
         System.out.println("title" +title);
         System.out.println("contents:" +contents);
         
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
         pw.close();
          }
      //  processRequest(request, response);
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NoteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NoteServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>[POST]</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
