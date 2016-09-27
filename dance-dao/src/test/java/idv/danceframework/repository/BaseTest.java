package idv.danceframework.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-dao.xml")
public abstract class BaseTest<Repository, T> extends AbstractJUnit4SpringContextTests {

	@Autowired
	protected Repository repository;

	protected T entity;

	public abstract void findOne();
}
