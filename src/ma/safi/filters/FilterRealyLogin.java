package ma.safi.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FilterRealyLogin
 */

@WebFilter(dispatcherTypes = {
		DispatcherType.REQUEST, 
		DispatcherType.FORWARD, 
		DispatcherType.INCLUDE
}
			, urlPatterns = { "/login/*" })

public class FilterRealyLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterRealyLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//chain.doFilter(request, response);
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse HttpResponse = (HttpServletResponse) response;
		HttpSession maSession = httpRequest.getSession();
		Boolean aut = (Boolean) maSession.getAttribute("authentifie");
		if (aut != null && aut == true) {
			HttpResponse.sendRedirect(HttpResponse.encodeRedirectURL(httpRequest.getContextPath()));

		}else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
