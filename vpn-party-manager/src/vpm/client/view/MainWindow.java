package vpm.client.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;

public class MainWindow extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = -1042796548198198003L;
    private final JPanel contentPanel = new JPanel();

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
		contentPanel.add(serverList);
	}
	{
		JButton btnConnect = new JButton("Connect");
		contentPanel.add(btnConnect);
	}
    }

}
