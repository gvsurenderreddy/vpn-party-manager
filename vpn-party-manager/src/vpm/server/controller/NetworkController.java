package vpm.server.controller;

import vpm.server.view.ViewEvent;
import vpm.server.view.ViewEventListener;

public class NetworkController implements ViewEventListener {

    @Override
    public void advertisement(ViewEvent event) {
	switch (event.getType()) {
	case STARTSERVER:
	    System.out.println("Server starts ..");
	    break;
	default:
	    break;
	}
    }

}
