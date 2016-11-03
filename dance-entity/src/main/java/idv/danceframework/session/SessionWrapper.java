package idv.danceframework.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import idv.danceframework.bo.CurrentUser;

/**
 * all object save in session
 * 
 * @author Davis Chen
 *
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionWrapper implements Serializable {

	private static final long serialVersionUID = 1L;

	private CurrentUser user;

	public CurrentUser getUser() {
		return user;
	}

	public void setUser(CurrentUser user) {
		this.user = user;
	}

}
