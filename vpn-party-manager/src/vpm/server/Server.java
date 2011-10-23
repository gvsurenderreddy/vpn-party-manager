package vpm.server;

import java.util.Timer;

import vpm.server.view.MainWindow;

public class Server {

    public final static String SERVER_UPDATE_URL = "http://vpn-party-manager.appspot.com/server/update";

    public final static String SERVER_LIST_URL = "http://vpn-party-manager.appspot.com/server/list";

    public static String NAME = "Name";

    public static String PORT = "493098";

    private static MainWindow window = new MainWindow();

    private static ServerUpdateTask sut = new ServerUpdateTask();

    public static void main(String[] args) {
	System.out.println("Starting...");

	sut.start();
	window.setVisible(true);
	System.out.println("End");

    }
}
