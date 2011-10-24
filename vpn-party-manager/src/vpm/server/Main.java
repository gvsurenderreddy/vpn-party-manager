package vpm.server;

import vpm.server.model.Server;
import vpm.server.view.MainWindow;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
	Server server = new Server();
	MainWindow window = new MainWindow(server);

	System.out.println("Starting...");
	window.setServer(server);
	window.setVisible(true);
	System.out.println("End");
    }

}
