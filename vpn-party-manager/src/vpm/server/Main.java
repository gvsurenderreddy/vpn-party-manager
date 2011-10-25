package vpm.server;

import vpm.server.controller.NetworkController;
import vpm.server.model.Server;
import vpm.server.view.MainWindow;
import vpm.server.view.ViewObserver;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Server server = new Server();
	ViewObserver viewObserver = new ViewObserver();
	NetworkController networkC = new NetworkController();
	MainWindow window = new MainWindow(server);

	viewObserver.addListener(networkC);

	System.out.println("Starting...");
	window.setServer(server);
	window.setViewObserver(viewObserver);
	window.setVisible(true);
	System.out.println("End");
    }

}
