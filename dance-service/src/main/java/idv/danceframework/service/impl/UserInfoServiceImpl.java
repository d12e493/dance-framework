package idv.danceframework.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idv.danceframework.entity.UserInfo;
import idv.danceframework.lo.PageResult;
import idv.danceframework.lo.UserInfoLO;
import idv.danceframework.qo.PageRequest;
import idv.danceframework.qo.UserInfoQO;
import idv.danceframework.repository.UserInfoRepository;
import idv.danceframework.service.UserInfoService;
import idv.danceframework.util.StringUtils;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoRepository, UserInfo, Long>
		implements UserInfoService {

	private final static Logger LOG = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public boolean checkPassword(String email, String password) {
		try {
			// check user input is not null
			if (StringUtils.isNotBlank(email) && StringUtils.isNotBlank(password)) {

				// check userId in db
				UserInfo dbUser = findByEmail(email);
				if (dbUser != null) {
					String inputPasswordHex = DigestUtils.sha256Hex(password);
					if (inputPasswordHex.equals(dbUser.getPassword())) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		return false;
	}

	@Override
	public UserInfo findByEmail(String email) {
		if (StringUtils.isNotBlank(email)) {
			return userInfoRepository.findByEmail(email);
		}
		return null;
	}

	@Override
	public PageResult<UserInfoLO> findAll(UserInfoQO queryObject, PageRequest pageRequest) {
		return findAll(queryObject, pageRequest, UserInfoLO.class);
	}

	@Override
	public void remove(Long id) {
		
	}

}
