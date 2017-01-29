package idv.danceframework.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import idv.danceframework.entity.User;
import idv.danceframework.session.SessionWrapper;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private User user;

	@Autowired
	private ApplicationContext context;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = (String) authentication.getCredentials();

		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			throw new UsernameNotFoundException("email / password is empty !!! ");
		}

//		if (userInfoService.checkPassword(email, password)) {
//
//			this.user = userInfoService.findByEmail(email);
//
//			authority();
//
//			Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), password,
//					Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
//
//			return auth;
//		}
		return null;
	}

	/**
	 * 自訂的登入後流程
	 * 
	 * @author Davis Chen
	 */
	private void authority() {
		SessionWrapper sessionWrapper = context.getBean(SessionWrapper.class);

		if (user != null) {
			
			System.out.println("sessionWrapper memory : " + sessionWrapper.hashCode());
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
