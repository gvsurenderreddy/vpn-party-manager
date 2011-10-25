package vpm.server.view;

import java.util.LinkedList;
import java.util.List;

public class ViewObserver {

    private List<ViewEventListener> listeners = new LinkedList<ViewEventListener>();

    public ViewObserver() {
    }

    public void addListener(ViewEventListener listener) {
	listeners.add(listener);
    }

    public void removeListener(ViewEventListener listener) {
	listeners.remove(listener);
    }

    public synchronized void notifyAdvertisement(ViewEvent event) {
	for (ViewEventListener listener : listeners) {
	    listener.advertisement(event);
	}
    }

}
