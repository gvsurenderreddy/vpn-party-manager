package vpm.client.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

import vpm.client.model.Server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Network {

    public static List<Server> getServerList() {
	List<Server> server = new LinkedList<Server>();
	Gson gson = new Gson();
	Type collectionType = new TypeToken<List<Server>>() {
	}.getType();
	server.addAll((List<Server>) gson.fromJson(
		readFromUrl(vpm.server.Server.SERVER_LIST_URL), collectionType));
	return server;
    }

    public static String readFromUrl(String url) {
	URL url_ = null;
	URLConnection uc = null;
	BufferedReader in = null;
	StringBuilder str = new StringBuilder();
	try {
	    url_ = new URL(url);
	    uc = url_.openConnection();
	    in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
	    String inputLine;

	    while ((inputLine = in.readLine()) != null)
		str.append(inputLine);
	    in.close();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return str.toString();
    }

}
