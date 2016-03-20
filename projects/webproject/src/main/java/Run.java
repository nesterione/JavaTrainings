import java.util.List;

import org.apache.tomcat.websocket.Transformation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itclass.model.User;
import com.itclass.services.hibernate.SessionManager;

public class Run {
	
	public static void main(String[] args) {
		
		Session session = SessionManager.openSession();
		
//		Transaction t = session.beginTransaction();
//		User user = new User(488,"sdf","24234");
//		session.save(user);
//		
//		t.commit();
		
		@SuppressWarnings("unchecked")
		List<User> users = session
			.createCriteria(User.class)
			.list();
		
		System.out.println(users);
		
		
		session.close();
	}
	
}
