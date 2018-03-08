package net.sanjeev.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException(){
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("title","404 error page");
		modelAndView.addObject("errorTitle","The page is not constructed!");
		modelAndView.addObject("errorDescription","The page you are looking for is not available now!");
		
		
		return modelAndView;
	
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductFoundException(){
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("title","Product unavailable");
		modelAndView.addObject("errorTitle","Product not available!");
		modelAndView.addObject("errorDescription","The product you are looking for is not available now!");
		
		
		return modelAndView;
	
	}
	
	 
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex){
		
		//Only for debugging purpose
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		ModelAndView modelAndView = new ModelAndView("error");
		
		modelAndView.addObject("title","Error");
		modelAndView.addObject("errorTitle","Contact your administrator!");
		modelAndView.addObject("errorDescription", sw.toString());
		
		
		return modelAndView;
	}
}
