package ex0410.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {
	long start, end;
	@Override
    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("RequestListener�� requestInitialized");
        
        start = System.nanoTime();
    }
    
	@Override
    public void requestDestroyed(ServletRequestEvent e)  { 
        System.out.println("RequestListener�� requestDestroyed");
        
        
        ServletRequest sr = e.getServletRequest();
        HttpServletRequest request = (HttpServletRequest)sr;
        String url = request.getRequestURL().toString();
        
        end = System.nanoTime();
        System.out.println(url + "�� ��û�� �� �ҿ� �ð�: " + (end-start) + "ns");      
    }
}
