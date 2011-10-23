package vpm.client.model;

import java.io.Serializable;
import java.util.Date;

public class Server implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8873664735012439550L;

    private String name;
    private String ip;
    private String port;
    private Date date;

    public Server() {

    }

    public String getName() {
	return name;
    }

    public String getIp() {
	return ip;
    }

    public String getPort() {
	return port;
    }

}
