package br.com.crescer.aula05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "pessoa", urlPatterns = ("/pessoa"))
public class PessoaServlet extends HttpServlet{
    
    List<Pessoa> pessoas = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String nome = request.getParameter("nome");
         String sexo = request.getParameter("gender");
         int idade = Integer.parseInt(request.getParameter("idade"));
         pessoas.add(new Pessoa(nome,sexo,idade));
            
            response.setContentType("text/html");
            try(final PrintWriter out = response.getWriter();) {
                out.append("<!DOCTYPE html>");
                out.append("<html>");
                out.append("<head>");
                out.append("<title>Java - aula5</title>");
                out.append("<meta charset=\"UTF-8\">");
                out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.append("</head>");
                out.append("<body>");
                out.append("<table> "
                + "<tr>\n" +
                "<th>Sexo</th>\n" +
                "<th>Nome</th>\n" +
                "<th>Idade</th>\n" +
                "</tr>");
                
                for (Pessoa pessoa: pessoas){
                    out.append("<tr>");
                    out.append("<th>"+pessoa.getSexo()+"</th>");
                    out.append("<th>"+pessoa.getNome()+"</th>");
                    out.append("<th>"+pessoa.getIdade()+"</th>");
                    out.append("</tr>");
                }                
                
                out.append("</table>"); 
                out.append("</body>");
                out.append("</html>");
            }
    }

     
}
