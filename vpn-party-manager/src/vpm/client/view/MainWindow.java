package vpm.client.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vpm.client.logic.Network;
import vpm.client.model.Server;

public class MainWindow extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = -1042796548198198003L;
    private final JPanel contentPanel = new JPanel();

    DefaultListModel serverListModel = new DefaultListModel();

    /**
     * Create the dialog.
     */
    public MainWindow() {
	setTitle("VPN Party Manager");
	this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
	{
	    Component horizontalStrut = Box.createHorizontalStrut(20);
	    contentPanel.add(horizontalStrut);
	}
	{
	    JList serverList = new JList();
	    serverList.setModel(serverListModel);
	    contentPanel.add(serverList);
	}
	{
	    JButton btnConnect = new JButton("Connect");
	    contentPanel.add(btnConnect);
	}
	init();
    }

    private void init() {
	initServerList();
    }

    private void initServerList() {
	List<Server> server = new LinkedList<Server>();
	server.addAll(Network.getServerList());
	for (Server ser : server) {
	    serverListModel.addElement(new String(ser.getName() + " "
		    + ser.getIp() + " " + ser.getPort()));
	}
    }

}
