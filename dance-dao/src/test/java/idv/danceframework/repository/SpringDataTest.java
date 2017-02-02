package idv.danceframework.repository;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import idv.danceframework.entity.User;
import idv.danceframework.sql.NativeSQLRepository;
import idv.danceframework.sql.PageQueryWrapper;
import idv.danceframework.vo.UserVO;

public class SpringDataTest {
	private ApplicationContext ctx = null;

	{
		ctx = new ClassPathXmlApplicationContext("application-dao.xml");
	}

	@Test
	@Ignore
	public void testSpringData() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	@Ignore
	public void testGetByLastName(){
	    UserRepository userRepository = ctx.getBean(UserRepository.class);
	    User user = userRepository.findOne(0L);
	    System.out.println(user);
	}
	
	@Test
	public void testNativePageQuery(){
		NativeSQLRepository repository = ctx.getBean(NativeSQLRepository.class);
		
		PageQueryWrapper wrapper = new PageQueryWrapper(UserVO.class);
		
		repository.query(wrapper);
		
	}
}
