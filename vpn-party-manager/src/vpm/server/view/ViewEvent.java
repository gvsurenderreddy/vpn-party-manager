package vpm.server.view;

import java.util.EventObject;

public class ViewEvent extends EventObject {

    /**
     * 
     */
    private static final long serialVersionUID = 2378511578345842148L;

    public enum Type {
	NOTHING, STARTSERVER
    }

    private Type type = Type.NOTHING;

    public ViewEvent(Object source, Type type) {
	super(source);
	this.type = type;
    }

    public Type getType() {
	return type;
    }

}
