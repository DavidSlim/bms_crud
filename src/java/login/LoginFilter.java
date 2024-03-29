package login;

import HoldersLoginMsg.LoginGS;
import HoldersLoginMsg.TrueFalse;
import HoldersLoginMsg.holder;
import java.io.IOException;
import javax.inject.Inject;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter checks if LoginGS has loginIn property set to true. If it is not set
 * then request is being redirected to the login.xhml page.
 */
public class LoginFilter implements Filter {

    private @Inject
    ConditionalNavs.NavConditions nav_;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Get the loginBean from session attribute
        UserLoginBean loginBean = (UserLoginBean) ((HttpServletRequest) request).getSession().getAttribute("loginBean");
        // For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        if (loginBean == null || !loginBean.getLogin_cred().isLoggedIn()) {
            ((HttpServletRequest) request).getSession().removeAttribute("loginBean");
            String contextPath = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse) response).sendRedirect(contextPath + nav_.login_form());
        } else {
            chain.doFilter(request, response);
            System.out.println("FILLLLTERRRRRRREDDDDDDDDDDDDD = " + loginBean.getLogin_cred().getLogName() + " PASSWORRDDD = " + loginBean.getLogin_cred().getLogPass());
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }

    @Override
    public void destroy() {
        // Nothing to do here!
    }

}
