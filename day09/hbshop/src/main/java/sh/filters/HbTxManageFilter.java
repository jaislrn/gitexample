package sh.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import sh.util.HbUtil;

//@WebFilter(urlPatterns = "/*")
public class HbTxManageFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String uri = ((HttpServletRequest)request).getRequestURI();
		try {
			System.out.println("beginTx() for " + uri);
			HbUtil.beginTransaction();
			chain.doFilter(request, response);
			HbUtil.commitTransaction();
			System.out.println("commitTx() for " + uri);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rollbackTx() for " + uri);
			HbUtil.rollbackTransaction();
		}
	}
}



