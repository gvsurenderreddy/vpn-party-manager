package vpm.server.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vpm.server.model.Server;

public class MainWindow extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 3246417769853135741L;
    private JPanel contentPane;
    private JTextField serverNameTextField;
    private JTextField portTextField;
    private Server server;
    private ViewObserver viewObserver;

    /**
     * Create the frame.
     */
    public MainWindow(Server s) {
	this.server = s;
	setTitle("VPM - Server");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// create custom close operation
	this.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
		exitProcedure();
	    }

	});
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblServerName = new JLabel("Server Name: ");
	lblServerName.setBounds(34, 22, 84, 16);
	contentPane.add(lblServerName);

	serverNameTextField = new JTextField(server.getName());
	serverNameTextField.setBounds(123, 19, 116, 22);
	contentPane.add(serverNameTextField);
	serverNameTextField.setColumns(10);

	JLabel lblPort = new JLabel("Port: ");
	lblPort.setBounds(34, 51, 32, 16);
	contentPane.add(lblPort);

	portTextField = new JTextField(server.getPort());
	portTextField.setBounds(123, 48, 116, 22);
	contentPane.add(portTextField);
	portTextField.setColumns(10);

	JButton btnStartServer = new JButton("start Server");
	btnStartServer.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		server.setName(serverNameTextField.getText());
		server.getConfig().set("servername",
			serverNameTextField.getText());
		server.setPort(portTextField.getText());
		server.getConfig().set("serverport", portTextField.getText());
		server.getServerUpdateTask().start();
		viewObserver.notifyAdvertisement(new ViewEvent(this,
			ViewEvent.Type.STARTSERVER));
	    }
	});
	btnStartServer.setBounds(302, 196, 101, 25);
	contentPane.add(btnStartServer);

    }

    private void exitProcedure() {
	server.getConfig().save();
    }

    public void setServer(Server server) {
	this.server = server;
    }

    public void setViewObserver(ViewObserver viewObserver) {
	this.viewObserver = viewObserver;
    }

}
