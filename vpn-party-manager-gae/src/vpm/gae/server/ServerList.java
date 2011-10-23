package vpm.gae.server;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class ServerList extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws IOException {
	List<Server> server = Server.getServer();
	String jsonString = "";
	Gson gson = new Gson();
	jsonString = gson.toJson(server);
	resp.setContentType("text/plain");
	resp.getWriter().print(jsonString);
    }

}
