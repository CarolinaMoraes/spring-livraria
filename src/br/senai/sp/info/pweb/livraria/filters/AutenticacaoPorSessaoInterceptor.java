package br.senai.sp.info.pweb.livraria.filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AutenticacaoPorSessaoInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		System.out.println("INterceptou!");
		
		boolean necessitaAutenticacao = req.getRequestURI().contains("/app");
		
		if(necessitaAutenticacao && req.getSession().getAttribute("usuario") == null) {
			res.setStatus(403);
			return false;
		}else {
			return true;
		}
	}

}
