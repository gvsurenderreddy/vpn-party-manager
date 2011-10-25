package vpm.server.model;

public class NetworkThread extends Thread {

    private Server server;

    private ServerUpdateTask serverUpdateTask;

    public NetworkThread(Server server) {
	super();
	this.server = server;
    }

    public void start() {
	super.start();
	serverUpdateTask = new ServerUpdateTask(server);
	serverUpdateTask.start();
    }

    @Override
    public void run() {
	while (true) {
	    System.out.println("running");
	    try {
		Thread.sleep(500);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

}
