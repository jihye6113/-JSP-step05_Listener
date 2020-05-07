package ex0410.listener;

import java.util.HashMap;
import java.util.Map;

import javax.activation.MailcapCommandMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {
 
    /**
     * ServletContext(application)이 start될때 호출 (서버가 시작될 때)
     * */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("AppListener의 contextInitialized.....");
		
		//각 나라별 국가코드 설정해서 모든 영역에서 사용할수 있도록 한다.
		Map<String, String> map = new HashMap<String, String>();
		map.put("kr", "대한민국");
		map.put("us", "미국");
		map.put("jp", "일본");
		map.put("cn", "중국");
	    map.put("fr", "프랑스");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);
		
		String contextPath = application.getContextPath();
		application.setAttribute("path", contextPath);
	}
	
	/**
     * ServletContext(application)이 stop될때 호출
     * */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener의 contextDestroyed ......");
	}

}