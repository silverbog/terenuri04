package terenuri3;

import java.util.HashMap;
import java.util.Map;
import terenuri3.UserDAO;
import terenuri3.ActiveDirectory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -4438762283384844161L;
	// private Map<String, Object> sessionMap;
	private Map session;
	// private String userName;
	// private String password;
	private User user;

	public UserAction() {
		super();
		// this.sessionMap = new HashMap<String, Object>();
		this.session = (Map) ServletActionContext.getContext().get("session");
		this.user = new User();

	}

	public String login() throws Exception {
		String loggedUserName = null;

		// check if the userName is already stored in the session
		if (session != null && session.containsKey(user.getUsername())) {
			loggedUserName = (String) session.get("userName");
		}
		if (loggedUserName != null && loggedUserName.equals("admin")) {
			return SUCCESS; // return welcome page
		}

		// if no userName stored in the session,
		// check the entered userName and password
		//if (user.getUsername() != null && user.getUsername().equals("admin") && user.getPassword() != null
		//		&& user.getPassword().equals("nimda")) {

		if (user.getUsername() != null  && user.getPassword() != null) {

			/**
			 * 1. Caut sa vad daca este inregistrat in aplicatie (bd locala exista username)
			 * 2. Daca este atunci Validez parola in AD 
			 * 3. Daca e ok parola de AD scriu userul in sesiunea curenta si 
			 * 4. Ii dau drept sa continue 5. 
			 * partea de roluri nu este tratata
			 */

			// 1.
			if (terenuri3.UserDAO.getUserByUsername(this.getUser()) != null) {
				// a fost gasit un teren pe care il si cautam
				// continui cu autentificarea in  AD
				System.out.println("Am gasit userul in baza de date locala!");
				
				try {					
					terenuri3.ActiveDirectory.getConnection(user.getUsername(), user.getPassword(),"ancpi.ro");
					//System.out.println("Am gasit userul in ACTIVE DIRECTORY!");
				} catch (Exception e) {
					System.out.println(e.toString());
					return INPUT; //nu a fost gasit userul in AD
				}
			}
			
			// scriu direct in session si nu in sessionMap
			session.put("userName", user.getUsername());
			return SUCCESS; // go to welcome page
		}

		// in other cases, return login page
		return INPUT;
	}

	public String logout() {
		// remove userName from the session
		// scriu direct in session si nu in sessionMap
		Map session = (Map) ServletActionContext.getContext().get("session");

		if (session.containsKey("userName")) {
			session.remove("userName");
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map getSession() {
		return session;
	}

}
