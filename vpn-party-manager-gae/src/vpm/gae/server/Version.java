package vpm.gae.server;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class Version extends HttpServlet {
    private static final String VERSION = "0.1";

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws IOException {
	resp.getWriter().print(VERSION);
    }

}
