/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DIPTO
 */
public class TeamVsFrame extends javax.swing.JFrame {

	/**
	 * Creates new form VsFrame
	 */
	public TeamVsFrame() {
		initComponents();
	}

	public TeamVsFrame(String team1, String team2, int win1, int win2,
			int goal1, int goal2, int draw, int totalplayed,Connection con,Statement st) {
		initComponents(team1, team2, win1, win2, goal1, goal2, draw,
				totalplayed,con,st);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

	}

	private void initComponents(String teamname1, String teamname2,
			int wincount1, int wincount2, int goalcount1, int goalcount2,
			int drawcount, int totalplayed,Connection con,Statement st) {

		jPanel1 = new javax.swing.JPanel();
		projnameLabel = new javax.swing.JLabel();
		playerphoto1 = new javax.swing.JLabel();
		playerphoto2 = new javax.swing.JLabel();
		team1 = new javax.swing.JLabel();
		team2 = new javax.swing.JLabel();
		winLabel = new javax.swing.JLabel();
		goalLabel = new javax.swing.JLabel();
		drawLabel = new javax.swing.JLabel();
		win1 = new javax.swing.JTextField();
		win2 = new javax.swing.JTextField();
		goal1 = new javax.swing.JTextField();
		goal2 = new javax.swing.JTextField();
		draw = new javax.swing.JTextField();
		backButton = new javax.swing.JButton();
		totalPlayedLabel = new javax.swing.JLabel();
		totalPlayedField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		
		String label1sql = "select clubid from club where clubname = '"
				+ teamname1 + "'";
		String label1find = null;
		try {
			ResultSet rs = st.executeQuery(label1sql);
			while (rs.next()) {
				label1find = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String label2sql = "select clubid from club where clubname = '"
				+ teamname2 + "'";
		String label2find = null;
		try {
			ResultSet rs = st.executeQuery(label2sql);
			while (rs.next()) {
				label2find = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setTitle("Team Comparision");
		setResizable(false);

		jPanel1.setLayout(null);

		projnameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
		projnameLabel.setText("Goal!!!");
		jPanel1.add(projnameLabel);
		projnameLabel.setBounds(10, 10, 110, 51);

		playerphoto1.setIcon(new javax.swing.ImageIcon(
				"C:\\Users\\DIPTO\\workspace\\Goal\\club_logos\\"+label1find+".png")); // NOI18N
		playerphoto1.setText("jLabel2");
		jPanel1.add(playerphoto1);
		playerphoto1.setBounds(20, 150, 200, 200);

		playerphoto2.setIcon(new javax.swing.ImageIcon(
				"C:\\Users\\DIPTO\\workspace\\Goal\\club_logos\\"+label2find+".png")); // NOI18N
		playerphoto2.setText("jLabel2");
		jPanel1.add(playerphoto2);
		playerphoto2.setBounds(790, 140, 200, 200);

		team1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		team1.setText(teamname1);
		jPanel1.add(team1);
		team1.setBounds(250, 80, 160, 32);

		team2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		team2.setText(teamname2);
		jPanel1.add(team2);
		team2.setBounds(620, 80, 170, 32);

		winLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		winLabel.setText("Win");
		jPanel1.add(winLabel);
		winLabel.setBounds(470, 160, 42, 32);

		goalLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		goalLabel.setText("Goal");
		jPanel1.add(goalLabel);
		goalLabel.setBounds(470, 210, 60, 40);

		drawLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		drawLabel.setText("Draw");
		jPanel1.add(drawLabel);
		drawLabel.setBounds(320, 280, 140, 50);

		win1.setText("" + wincount1);
		win1.setEditable(false);
		jPanel1.add(win1);
		win1.setBounds(250, 160, 120, 30);

		win2.setText("" + wincount2);
		win2.setEditable(false);
		jPanel1.add(win2);
		win2.setBounds(620, 160, 130, 30);

		goal1.setText("" + goalcount1);
		goal1.setEditable(false);
		jPanel1.add(goal1);
		goal1.setBounds(250, 220, 120, 30);

		goal2.setText("" + goalcount2);
		goal2.setEditable(false);
		jPanel1.add(goal2);
		goal2.setBounds(620, 220, 130, 30);

		draw.setText("" + drawcount);
		draw.setEditable(false);
		jPanel1.add(draw);
		draw.setBounds(520, 290, 130, 30);

		backButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		backButton.setText("Back");
		jPanel1.add(backButton);
		backButton.setBounds(450, 440, 90, 41);
		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});

		totalPlayedLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		totalPlayedLabel.setText("Total Played");
		totalPlayedLabel.setVisible(false);
		jPanel1.add(totalPlayedLabel);
		totalPlayedLabel.setBounds(320, 350, 150, 32);

		totalPlayedField.setText("" + totalplayed);
		totalPlayedField.setEditable(false);
		totalPlayedField.setVisible(false);
		totalPlayedField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		jPanel1.add(totalPlayedField);
		totalPlayedField.setBounds(520, 350, 130, 30);

		jLabel1.setIcon(new javax.swing.ImageIcon(
				"E:\\BUET\\Level 3 Term 1\\CSE 304\\project\\vsback.jpg")); // NOI18N
		jPanel1.add(jLabel1);
		jLabel1.setBounds(0, 0, 1024, 540);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TeamVsFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TeamVsFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TeamVsFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TeamVsFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TeamVsFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton backButton;
	private javax.swing.JTextField draw;
	private javax.swing.JLabel drawLabel;
	private javax.swing.JTextField goal1;
	private javax.swing.JTextField goal2;
	private javax.swing.JLabel goalLabel;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JLabel playerphoto1;
	private javax.swing.JLabel playerphoto2;
	private javax.swing.JLabel projnameLabel;
	private javax.swing.JLabel team1;
	private javax.swing.JLabel team2;
	private javax.swing.JTextField totalPlayedField;
	private javax.swing.JLabel totalPlayedLabel;
	private javax.swing.JTextField win1;
	private javax.swing.JTextField win2;
	private javax.swing.JLabel winLabel;
	// End of variables declaration
}
