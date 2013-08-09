package ch.bebforst.bebaweb.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextHelper {

	private final ApplicationContext context;

	public SpringContextHelper(ServletContext servletContext) {
		/*
		 * ServletContext servletContext = ((WebApplicationContext) application.getContext()) .getHttpSession().getServletContext();
		 */
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	}

	public <T> T getBean(Class<T> type) {
		return context.getBean(type);
	}

	public Object getBean(final String beanRef) {
		return context.getBean(beanRef);
	}
}
