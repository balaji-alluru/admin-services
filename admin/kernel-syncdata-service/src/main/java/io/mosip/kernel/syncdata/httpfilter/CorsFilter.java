package io.mosip.kernel.syncdata.httpfilter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * This class is a filter for giving Access Headers to solve CORS
 * 
 * @author Mindtree Ltd.
 *
 */
@SuppressWarnings("findsecbugs:PERMISSIVE_CORS")
public class CorsFilter implements Filter {
	/**
	 * Default Constructor
	 */
	public CorsFilter() {
		// Default Constructor
	}

	@SuppressWarnings("findbugs:HRS_REQUEST_PARAMETER_TO_HTTP_HEADER")
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String origin = request.getHeader("Origin");
		if (origin != null && !origin.isEmpty()) {
			response.setHeader("Access-Control-Allow-Origin", origin);
		}
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, PATCH");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Date, Content-Type, Accept, X-Requested-With, Authorization, From, X-Auth-Token, Request-Id");
		response.setHeader("Access-Control-Expose-Headers", "Date, Response-Signature");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		/*
		 * response.setHeader("X-Frame-Options", "SAMEORIGIN");
		 * response.setHeader("X-Content-Type-Options", "nosniff");
		 * response.setHeader("X-XSS-Protection", "1; mode=block");
		 * response.setHeader("Cache-Control", "No-store"); response.setHeader("Pragma",
		 * "no-cache");
		 */
		if (!"OPTIONS".equalsIgnoreCase(request.getMethod())) {
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) {
		// init method from Filter
	}

	@Override
	public void destroy() {
		// destroy method from Filter
	}
}