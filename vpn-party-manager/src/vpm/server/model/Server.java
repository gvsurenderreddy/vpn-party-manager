package vpm.server.model;

public class Server {

    public final static String SERVER_UPDATE_URL = "http://vpn-party-manager.appspot.com/server/update";

    public final static String SERVER_LIST_URL = "http://vpn-party-manager.appspot.com/server/list";

    private String name = "NoobHost";

    private String port = "493098";

    private Config config;

    public Server() {
	config = new Config();
	config.load();
	String name = config.get("servername");
	String port = config.get("serverport");
	if (name != null)
	    this.name = name;
	if (port != null)
	    this.port = port;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setPort(String port) {
	try {
	    if (Integer.parseInt(port) > 0)
		this.port = port;
	} catch (NumberFormatException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    public String getPort() {
	return port;
    }

    public Config getConfig() {
	return config;
    }
}
