package idv.danceframework.repository;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.danceframework.entity.User;

public class SpringDataTest {
	private ApplicationContext ctx = null;

	{
		ctx = new ClassPathXmlApplicationContext("application-dao.xml");
	}

	@Test
	public void testSpringData() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testGetByLastName(){
	    UserRepository userRepository = ctx.getBean(UserRepository.class);
	    User user = userRepository.findOne(0L);
	    System.out.println(user);
	}
}
