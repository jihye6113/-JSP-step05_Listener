package ex0410.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 * 
 * tomcat version 9.x�̹Ƿ� interface�� �ִ� �޼ҵ尡 default �̴�.
 * �ʿ��� �޼ҵ常 �������ص� ��
 *
 */
@WebListener //�ٸ� �ɼ� ���� ��ϿϷ��
public class UserAccessCounterListener implements ServletContextListener, HttpSessionListener {
   /**
    * 1.������ start�� �� ������ ���� count���� ������ �ʱ�ȭ �۾� �ʿ�
    */
   ServletContext application;
   @Override
   public void contextInitialized(ServletContextEvent e) {
      application = e.getServletContext();
      //���� start�� �� count = 0
      application.setAttribute("count", new AtomicInteger());//�ʱⰪ0
   }
   
   /**
    * 2. session�� ���۵Ǹ� ������ ���� ������Ŵ
    */
   @Override
   public void sessionCreated(HttpSessionEvent e) {
      AtomicInteger count = (AtomicInteger)application.getAttribute("count");
      int i = count.incrementAndGet(); //��������
      
      System.out.println("������ �� : " + i + " ��");
   }
   
   /**
    * 3. session ����Ǹ� ������ �� ���ҽ�Ŵ
    */
   @Override
   public void sessionDestroyed(HttpSessionEvent e) {
      AtomicInteger count = (AtomicInteger)application.getAttribute("count");
      int i = count.decrementAndGet();
      System.out.println("���ҵ� �� : " + i + " ��");
   }
}//end