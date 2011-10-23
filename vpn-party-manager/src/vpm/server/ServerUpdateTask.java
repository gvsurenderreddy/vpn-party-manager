package vpm.server;

import java.util.Timer;
import java.util.TimerTask;

import vpm.shared.Network;

public class ServerUpdateTask extends TimerTask {

    Timer timer = new Timer();

    @Override
    public void run() {
	String url = Server.SERVER_UPDATE_URL + "?name=" + Server.NAME
		+ "&port=" + Server.PORT;
	Network.readFromUrl(url);
    }

    public void start() {
	timer.schedule(this, 1, 1000 * 60 * 2);
    }

    public void stop() {
	timer.cancel();
    }

}
