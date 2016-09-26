package idv.danceframework.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import idv.danceframework.service.UserInfoService;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserInfoService userInfoService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = (String) authentication.getCredentials();

		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			throw new UsernameNotFoundException("email / password is empty !!! ");
		}

		if (userInfoService.checkPassword(email, password)) {
			return new UsernamePasswordAuthenticationToken(userInfoService.findByEmail(email), password,
					Arrays.asList(new SimpleGrantedAuthority("USER")));
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
