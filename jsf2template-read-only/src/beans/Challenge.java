package beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;


public class Challenge {
	
	private String nickname;
	private Double bet;
	private String when;
	private String time;
	private Boolean available;

	
	
	public Boolean getAvailable() {
		return available;
	}



	public void setAvailable(Boolean available) {
		this.available = available;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getWhere() {
		return where;
	}



	public void setWhere(String where) {
		this.where = where;
	}
	private String where;
	
	
	
	public void create()
	{
		//store all data in datastore;
        Entity challenge = new Entity("Challenge");
        challenge.setProperty("nickname", nickname);
        challenge.setProperty("bet", bet);
       /// Date date = new Date();
        challenge.setProperty("when", when);
        challenge.setProperty("time", time);
        challenge.setProperty("where",where);
        challenge.setProperty("available", true);
        // store also the user that is doing this transaction
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        challenge.setProperty("useremail", user.getEmail());
        
        Datastore.datastore.put(challenge);
		
		//return "something";
		System.out.println("Created a challenge");
	}
	
	public void ListAvailableChallenges()
	{
		/*Filter challengeAvailableFilter =
				  new FilterPredicate("available",
				                      FilterOperator.EQUAL,
				                      true);
		*/
		// Use class Query to assemble a query
		Query q = new Query("Challenge");//.setFilter(challengeAvailableFilter);

		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = Datastore.datastore.prepare(q);

		System.out.print("Available:");
		for (Entity result : pq.asIterable()) {
		  String nickname = (String) result.getProperty("nickname");
		  Double bet = (Double) result.getProperty("bet");
		  String when = (String) result.getProperty("when");

		  System.out.println(nickname + " " + bet + ", " + when );
		}

	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public Double getBet() {
		return bet;
	}
	public void setBet(Double bet) {
		this.bet = bet;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public String getMedia() {
		return where;
	}
	public void setMedia(String where) {
		this.where = where;
	}

}
