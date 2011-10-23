package vpm.gae.server;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ReServer extends HttpServlet {

    private static final Logger log = Logger
	    .getLogger(ReServer.class.getName());

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws IOException {
	List<Server> server = Server.getServer();
	List<Server> delete = new LinkedList<Server>();
	for (Server s : server) {
	    if (((new Date()).getTime() - s.getDate().getTime()) > 5 * 60 * 1000)
		delete.add(s);
	}
	for (Server s : delete) {
	    s.delete();
	}
    }

}
