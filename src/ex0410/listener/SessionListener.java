package ex0410.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
	
	/**
	 * ������ ���۵� �� ȣ���
	 * */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionListener�� sessionCreated");
	}
	
	/**
	 * ������ ����� �� ȣ���
	 * : session timeout�� �� ��
	 * 	 session.invalidate()�� ȣ��� ��
	 * 	 �������� x�� Ŭ������ ���� ȣ����� �ʴ´�.
	 * */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionListener�� sessionDestroyed");
	}
	
}
