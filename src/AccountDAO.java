import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AccountDAO {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();
		
		SavingsAccount sa = new SavingsAccount();
		sa.setAccountNo(1234);
		sa.setBalance(20000);
		sa.setMinBalance(5000);
		
		CurrentAccount ca = new CurrentAccount();
		ca.setAccountNo(5678);
		ca.setBalance(30000);
		ca.setOdiLimit(2000);
		
		session.save(sa);
		session.save(ca);
		t.commit();
		System.out.println("Successfully saved");
		session.close();
		factory.close();
		System.out.println("Objects saved in DB");
	}
}
