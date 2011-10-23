package vpm.server;

import java.util.Timer;
import java.util.TimerTask;

import vpm.server.model.Server;
import vpm.shared.Network;

public class ServerUpdateTask extends TimerTask {

    Timer timer = new Timer();
    
    Server server;

    public ServerUpdateTask(Server server){
	this.server = server;
    }

    @Override
    public void run() {
	String url = Server.SERVER_UPDATE_URL + "?name=" + server.getName()
		+ "&port=" + server.getPort();
	Network.readFromUrl(url);
    }

    public void start() {
	timer.schedule(this, 1, 1000 * 60 * 2);
    }

    public void stop() {
	timer.cancel();
    }

}
