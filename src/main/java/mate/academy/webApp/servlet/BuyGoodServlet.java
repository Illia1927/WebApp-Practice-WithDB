package mate.academy.webApp.servlet;

import mate.academy.webApp.dao.CodeDao;
import mate.academy.webApp.dao.impl.CodeDaoImpl;
import mate.academy.webApp.model.Code;
import mate.academy.webApp.model.User;
import mate.academy.webApp.service.MailService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/buy")
public class BuyGoodServlet extends HttpServlet {
    private static final MailService mailService = new MailService();
    private static final CodeDao codeDao = new CodeDaoImpl();
    private static final Logger logger = Logger.getLogger(BuyGoodServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String codeValue = req.getParameter("code");
        if (codeDao.getCodeByValue(codeValue).isPresent()) {
            resp.getWriter().print("payment successfully completed");
            logger.info("payment successfully");
        } else {
            resp.getWriter().print("payment is declined");
            logger.info("payment is declined");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long goodId = Long.parseLong(req.getParameter("id"));
        User user = (User) req.getSession().getAttribute("user");
        String randomCode = mailService.sendMailWithCode(user.getEmail());
        Code code = new Code(user.getUserId(), goodId, randomCode);
        codeDao.addCode(code);
        req.setAttribute("goodId", goodId);
        req.getRequestDispatcher("buyConfirmation.jsp").forward(req, resp);
    }
}
