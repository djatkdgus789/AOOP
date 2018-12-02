package eng;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DBLoad extends JFrame{
	Subject s;
	Frame f = new Frame();
	public DBLoad(Subject s) {
		Connection connection = null;
		
		this.s = s;
		
		setTitle("DBLOAD");
		
		ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)(e.getSource());
				
				String query = null;
				try {
					switch(btn.getText()){
					case "web":
						query = "SELECT * FROM WEBPROG";
						PreparedStatement pstweb = connection.prepareStatement(query);
						pstweb.execute();
						pstweb.close();
						break;
					case "oop":
						query = "SELECT * FROM WEBAOOP";
						PreparedStatement pstoop = connection.prepareStatement(query);
						pstoop.execute();
						pstoop.close();
						break;
					case "aoop":
						query = "SELECT * FROM WEBAOOP";
						PreparedStatement pstaoop = connection.prepareStatement(query);
						pstaoop.execute();
						pstaoop.close();
						break;
					}
				}catch(SQLException sqlException) {
			    	   sqlException.printStackTrace();
			    }
			}
		};
		
		setLayout(new BorderLayout(10, 10));
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		JButton web = new JButton("web");
		JButton oop = new JButton("oop");
		JButton aoop = new JButton("aoop");
		
		web.addActionListener(l);
		oop.addActionListener(l);
		aoop.addActionListener(l);
		
		panel.add(web);
		panel.add(oop);
		panel.add(aoop);
		
		add(panel, BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(100, 150);
		setVisible(true);
		
	}
 
}
