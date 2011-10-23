package vpm.gae.server;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Server {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    String name = null;

    @Persistent
    String ip = null;

    @Persistent
    String port = null;

    @Persistent
    Date date = new Date();

    private Server(String name, String ip, String port) {
	this.ip = ip;
	this.name = name;
	this.port = port;
    }

    public static Boolean updateServer(String name, String ip, String port) {
	Server server = getServer(name);
	if (server == null)
	    server = new Server(name, ip, port);
	if (!server.ip.equals(ip))
	    return false;
	server.port = port;
	server.date = new Date();
	save(server);
	return true;
    }

    private static Server getServer(String name) {
	PersistenceManager pm = PMF.get().getPersistenceManager();
	Server temp = null;
	try {
	    temp = pm.getObjectById(Server.class, name);
	} catch (JDOObjectNotFoundException e) {
	    temp = null;
	} finally {
	    pm.close();
	}
	return temp;
    }

    private static void save(Server server) {
	PersistenceManager pm = PMF.get().getPersistenceManager();
	try {
	    pm.makePersistent(server);
	} catch (Exception e) {
	} finally {
	    pm.close();
	}
    }

    public void delete() {

	PersistenceManager pm = PMF.get().getPersistenceManager();
	try {
	    pm.deletePersistent(pm.getObjectById(this.getClass(),
		    this.getName()));
	} catch (Exception e) {
	    System.out.println(e.getMessage());
	} finally {
	    pm.close();
	}
    }

    public static List<Server> getServer() {
	List<Server> server = new LinkedList<Server>();

	PersistenceManager pm = PMF.get().getPersistenceManager();
	String query = "select from " + Server.class.getName()
		+ " order by date desc";
	Query query_ = pm.newQuery(query);
	try {
	    server.addAll((List<Server>) query_.execute());
	} catch (Exception e) {
	} finally {
	    pm.close();
	}

	return server;
    }

    public String getIp() {
	return ip;
    }

    public String getName() {
	return name;
    }

    public String getPort() {
	return port;
    }

    public Date getDate() {
	return date;
    }

}
