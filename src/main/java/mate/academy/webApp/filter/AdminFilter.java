package mate.academy.webApp.filter;

import mate.academy.webApp.dao.hibernateDao.RoleDaoHib;
import mate.academy.webApp.dao.hibernateDao.impl.RoleDaoHibImpl;
import mate.academy.webApp.model.Role;
import mate.academy.webApp.model.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@WebFilter(urlPatterns = {"/adminPage.jsp", "/CRUD/goodsPage/addGoodPage.jsp",
        "/CRUD/goodsPage/updateGoods.jsp", "/CRUD/userPage/*", "/deleteGood"})
public class AdminFilter implements Filter {
    private static final RoleDaoHib roleDao = new RoleDaoHibImpl();

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        Role adminRole = roleDao.getByLogin("ADMIN").get();
        if (user.getRoles().contains(adminRole)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            request.getRequestDispatcher("/errorPage/accessDenied.jsp").forward(request, servletResponse);
        }
    }
}
