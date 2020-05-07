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
 * tomcat version 9.x이므로 interface에 있는 메소드가 default 이다.
 * 필요한 메소드만 재정의해도 됨
 *
 */
@WebListener //다른 옵션 없이 등록완료됨
public class UserAccessCounterListener implements ServletContextListener, HttpSessionListener {
   /**
    * 1.서버가 start될 때 접속자 수를 count해줄 변수의 초기화 작업 필요
    */
   ServletContext application;
   @Override
   public void contextInitialized(ServletContextEvent e) {
      application = e.getServletContext();
      //서버 start될 때 count = 0
      application.setAttribute("count", new AtomicInteger());//초기값0
   }
   
   /**
    * 2. session이 시작되면 접속자 수를 증가시킴
    */
   @Override
   public void sessionCreated(HttpSessionEvent e) {
      AtomicInteger count = (AtomicInteger)application.getAttribute("count");
      int i = count.incrementAndGet(); //최종증가
      
      System.out.println("증가된 후 : " + i + " 명");
   }
   
   /**
    * 3. session 종료되면 접속자 수 감소시킴
    */
   @Override
   public void sessionDestroyed(HttpSessionEvent e) {
      AtomicInteger count = (AtomicInteger)application.getAttribute("count");
      int i = count.decrementAndGet();
      System.out.println("감소된 후 : " + i + " 명");
   }
}//end