package ex0410.listener;

import java.util.HashMap;
import java.util.Map;

import javax.activation.MailcapCommandMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {
 
    /**
     * ServletContext(application)�� start�ɶ� ȣ�� (������ ���۵� ��)
     * */
	@Override
	public void contextInitialized(ServletContextEvent e) {
		System.out.println("AppListener�� contextInitialized.....");
		
		//�� ���� �����ڵ� �����ؼ� ��� �������� ����Ҽ� �ֵ��� �Ѵ�.
		Map<String, String> map = new HashMap<String, String>();
		map.put("kr", "���ѹα�");
		map.put("us", "�̱�");
		map.put("jp", "�Ϻ�");
		map.put("cn", "�߱�");
	    map.put("fr", "������");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);
		
		String contextPath = application.getContextPath();
		application.setAttribute("path", contextPath);
	}
	
	/**
     * ServletContext(application)�� stop�ɶ� ȣ��
     * */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("AppListener�� contextDestroyed ......");
	}

}