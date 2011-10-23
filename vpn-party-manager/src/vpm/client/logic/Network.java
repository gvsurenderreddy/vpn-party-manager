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
	server.addAll((List<Server>) gson.fromJson(vpm.shared.Network
		.readFromUrl(vpm.server.model.Server.SERVER_LIST_URL), collectionType));
	return server;
    }

}
