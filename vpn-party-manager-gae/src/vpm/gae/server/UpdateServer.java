package vpm.gae.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UpdateServer extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws IOException {
	String ip = req.getRemoteAddr();
	String name = req.getParameter("name");
	String port = req.getParameter("port");

	if (ip == null || name == null || port == null)
	    return;

	Server.updateServer(name, ip, port);

    }

}
