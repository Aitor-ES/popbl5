/**
 * @file ViewNameInModelInterceptor.java
 * @brief Class to define an interceptor to add the view name as a model attribute
 * @author Name  | Surname   | Email                        |
 * ------|-----------|--------------------------------------|
 * Aitor | Barreiro  | aitor.barreiro@alumni.mondragon.edu  |
 * Aitor | Estarrona | aitor.estarrona@alumni.mondragon.edu |
 * Iker  | Mendi     | iker.mendi@alumni.mondragon.edu      |
 * Julen | Uribarren | julen.uribarren@alumni.mondragon.edu |
 * @date 19/01/2019
 * @brief Package edu.mondragon.spring.configuration
 */
package edu.mondragon.spring.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ViewNameInModelInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * @brief Called after the request is processed by the HandlerAdapter. Used to obtain the view name
	 * @param request Defines an object to provide client request information to a servlet
	 * @param response Defines an object to assist a servlet in sending a response to the client
	 * @param handler Object to the postHanlde method
	 * @param modelAndView Holder for both Model and View in the web MVC framework
	 * @return void
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			modelAndView.addObject("springViewName", modelAndView.getViewName());
		}
		super.postHandle(request, response, handler, modelAndView);
	}
}
