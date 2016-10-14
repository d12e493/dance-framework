package idv.danceframework.repository;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-dao.xml" })
@Rollback
@Transactional(transactionManager = "transactionManager")
public abstract class BaseRepositoryTest<R extends BaseRepository> extends AbstractJUnit4SpringContextTests {

	@Autowired
	protected R repository;
}
