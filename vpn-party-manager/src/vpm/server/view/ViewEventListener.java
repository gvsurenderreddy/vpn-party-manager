package vpm.server.view;

import java.util.EventListener;

public interface ViewEventListener extends EventListener {
    void advertisement(ViewEvent e);
}
