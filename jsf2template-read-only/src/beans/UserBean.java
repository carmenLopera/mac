package beans;



import javax.faces.bean.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@ManagedBean(name="user")
public class UserBean {

	private String username;
	private String password;
	private Challenge[] listChallenges; // challenges created by user
	private Challenge[] listJointChallenges; //challenges joined by user
	
	

	
	


	public String login() {
		// retrieve account from datastore
		/*UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

		if (user.getEmail().equals(username)) {
			return ("useridentified");

			//return ("useridentified");
		} else {
			return ("usernonidentified");
		}
		
		*/
		return ("useridentified");

	}

	public String register() {
		// save in datastore new account
		//UserDataStore userDataStore = new UserDataStore();
		//userDataStore.storeKey(this);

		return ("login");
	}

	
	
	
	
	
	//getters and setters
	public Challenge[] getListChallenges() {
		return listChallenges;
	}

	public void setListChallenges(Challenge[] listChallenges) {
		listChallenges = listChallenges;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
