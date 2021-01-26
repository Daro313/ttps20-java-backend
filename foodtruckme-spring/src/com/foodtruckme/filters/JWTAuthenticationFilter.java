package com.foodtruckme.filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import com.foodtruckme.servicios.TokenService;

@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "*")
public class JWTAuthenticationFilter implements Filter {

	@SuppressWarnings("unused")
	private FilterConfig filterConf;
	private String urlLogin = "http://localhost:4200/users/autenticar";
	private String urlRegister = "http://localhost:4200/register";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConf = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		if (urlLogin.equals(req.getRequestURI()) || urlRegister.equals(req.getRequestURI()) || HttpMethod.OPTIONS.matches(req.getMethod())) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		
		if (token == null || !TokenService.validateToken(token)) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.setStatus(HttpStatus.FORBIDDEN.value());
			return;
		}
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void destroy() {
		this.filterConf = null;
	}

}