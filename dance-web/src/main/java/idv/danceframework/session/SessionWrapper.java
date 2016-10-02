package idv.danceframework.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import idv.danceframework.bo.CurrentUser;

/**
 * all object save in session
 * 
 * @author Davis Chen
 *
 */
@Component
@Scope("session")
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
