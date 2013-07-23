package beans;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

/*uses goolgle app engine datastore to put and retrieve data from the datastore*/
public class Datastore {
	
	public static DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();//todo move it to datastore class

    
}
