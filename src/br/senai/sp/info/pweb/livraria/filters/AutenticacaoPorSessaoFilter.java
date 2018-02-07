package br.senai.sp.info.pweb.livraria.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AutenticacaoPorSessaoFilter extends HttpFilter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("Filtrou");
		
		boolean necessitaAutenticacao = req.getRequestURI().contains("/app");
		
		if(necessitaAutenticacao && req.getSession().getAttribute("usuario") == null) {
			res.setStatus(403);
		}else {
			chain.doFilter(req, res);
		}
	}

}
