package servlet;

import bean.Hero;
import com.sun.javafx.binding.StringFormatter;
import com.sun.net.httpserver.HttpServer;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HeroListServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        List<Hero> heros = new HeroDao().listAll();

        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>float</td><td>damage</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td></tr>\r\n";
        for (Hero hero : heros) {
            String str = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage());
            sb.append(str);
        }

        sb.append("</table>");

        resp.getWriter().write(sb.toString());

    }
}
