package sh.beans;

import sh.daos.UserDao;
import sh.entities.User;
import sh.util.HbUtil;

public class UserBean {
	private String email;
	private String password;
	private User user;
	public UserBean() {
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void authenticate() {
		try {
			UserDao dao = new UserDao();
			HbUtil.beginTransaction();
			User dbUser = dao.findByEmail(this.email);
			if (dbUser != null && dbUser.getPassword().equals(this.password))
				this.user = dbUser;
			else
				this.user = null;
			HbUtil.commitTransaction();
		} catch (Exception e) {
			HbUtil.rollbackTransaction();
		}
	}
}





