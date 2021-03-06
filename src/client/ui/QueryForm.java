/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JOptionPane;

import org.omg.CORBA.OBJ_ADAPTER;

/**
 *
 * @author DIPTO
 */
public class QueryForm extends javax.swing.JFrame {

	/**
	 * Creates new form queryForm
	 */
	public QueryForm() {

	}

	public QueryForm(Connection con, Statement st) {
		initComponents(con, st);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents(Connection con, Statement st) {

		jPanel1 = new javax.swing.JPanel();
		projNameLabel = new javax.swing.JLabel();
		showallClubData = new javax.swing.JButton();
		closeButton = new javax.swing.JButton();
		countryList = new javax.swing.JComboBox();
		clubRankingLabel = new javax.swing.JLabel();
		findClubRanking = new javax.swing.JButton();
		teamList1 = new javax.swing.JComboBox();
		teamvsLabel = new javax.swing.JLabel();
		teamList2 = new javax.swing.JComboBox();
		findTeamVs = new javax.swing.JButton();
		playerList1 = new javax.swing.JComboBox();
		playerVsLabel = new javax.swing.JLabel();
		playerList2 = new javax.swing.JComboBox();
		playerVsButton = new javax.swing.JButton();
		playerList = new javax.swing.JComboBox();
		vsLabel = new javax.swing.JLabel();
		clubList = new javax.swing.JComboBox();
		playerVSTeamButton = new javax.swing.JButton();
		bestPlayerLabel = new javax.swing.JLabel();
		bestVsLabel = new javax.swing.JLabel();
		bestVsclubList = new javax.swing.JComboBox();
		bestFindButton = new javax.swing.JButton();
		showLeaderboardButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
		setTitle("Query");
		setResizable(false);

		jPanel1.setLayout(null);

		projNameLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
		projNameLabel.setText("Goal!!!");
		jPanel1.add(projNameLabel);
		projNameLabel.setBounds(20, 20, 70, 34);

		showallClubData.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		showallClubData.setText("Show All Clubs");
		jPanel1.add(showallClubData);
		showallClubData.setBounds(20, 60, 230, 41);
		showallClubData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				showallClubDataActionPerformed(evt);
			}

			private void showallClubDataActionPerformed(ActionEvent evt) {
				ResultSet rs;
				String sql = "select * from club";
				String[] colheads = { "Club ID", "Country ID", "Club",
						"Contact", "Owner", "Stadium" };
				Object data[][] = new Object[200][6];
				int i = 0;
				try {
					rs = st.executeQuery(sql);
					while (rs.next()) {
						System.out.println(rs.getInt(1) + " " + rs.getInt(2)
								+ " " + rs.getString(3) + " " + rs.getString(6)
								+ " " + rs.getString(7) + " " + rs.getString(8));
						data[i][0] = rs.getInt(1);
						data[i][1] = rs.getInt(2);
						data[i][2] = rs.getString(3);
						data[i][3] = rs.getString(6);
						data[i][4] = rs.getString(7);
						data[i][5] = rs.getString(8);
						// System.out.println("Hello");
						i++;
					}
					qTable = new QueryTable(data, colheads);
					qTable.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		closeButton.setText("Close");
		jPanel1.add(closeButton);
		closeButton.setBounds(860, 500, 59, 23);

		String[] countryOptions = { "All", "Spain", "England" };
		// ResultSet rs = st.executeQuery("select country")

		countryList.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		countryList.setModel(new javax.swing.DefaultComboBoxModel(
				countryOptions));
		jPanel1.add(countryList);
		countryList.setBounds(20, 120, 200, 38);

		clubRankingLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		clubRankingLabel.setText("Club Ranking");
		jPanel1.add(clubRankingLabel);
		clubRankingLabel.setBounds(250, 120, 150, 40);

		findClubRanking.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		findClubRanking.setText("Find");
		jPanel1.add(findClubRanking);
		findClubRanking.setBounds(420, 120, 90, 41);
		findClubRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (countryList.getSelectedItem().equals("All")) {
					String allclubrankingsql = "select coun.countryname, C.clubname, cps.w+cps.l+cps.d MATCH_PLAYED, cps.W WIN, cps.L LOSS, cps.D DRAW, cps.GF GOAL_FOR, cps.GA GOAL_AGAINST, cps.gf-cps.ga GOAL_DIFFERENCE, cps.Points from club_perf_season cps join club C on(cps.clubid= c.clubid) join country COUN on(c.countryid= coun.countryid) where cps.seasonid=(select s.seasonid from season s WHERE sysdate>= s.startdate and sysdate<= s.enddate) order by coun.countryname, cps.points desc, GOAL_DIFFERENCE desc, WIN desc";
					String[] colhead = { "Country Name", "Club Names",
							"Match Played", "Win", "Loss", "Draw", "GF", "GA",
							"Points" };
					Object data[][] = new Object[200][9];
					int i = 0;
					try {
						ResultSet rs = st.executeQuery(allclubrankingsql);
						while (rs.next()) {
							data[i][0] = rs.getString(1);
							data[i][1] = rs.getString(2);
							data[i][2] = rs.getInt(3);
							data[i][3] = rs.getInt(4);
							data[i][4] = rs.getInt(5);
							data[i][5] = rs.getInt(6);
							data[i][6] = rs.getInt(7);
							data[i][7] = rs.getInt(8);
							data[i][8] = rs.getInt(10);
							i++;
						}
						qTable = new QueryTable(data, colhead);
						qTable.setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					String allclubrankingsql = "select C.clubname, cps.w+cps.l+cps.d MP, cps.W, cps.L, cps.D, cps.GF, cps.GA, cps.gf-cps.ga GD, cps.Points from club_perf_season cps join club C on(cps.clubid= c.clubid) join country COUN on(c.countryid= coun.countryid) where cps.seasonid=(select s.seasonid from season s WHERE sysdate>= s.startdate and sysdate<= s.enddate) and coun.countryname='"
							+ (String) countryList.getSelectedItem()
							+ "' order by coun.countryname, cps.points desc, GD desc, W desc";
					String[] colhead = { "Club Names", "Match Played", "Win",
							"Loss", "Draw", "GF", "GA", "GD", "Points" };
					Object data[][] = new Object[200][10];
					int i = 0;
					try {
						ResultSet rs = st.executeQuery(allclubrankingsql);
						while (rs.next()) {
							data[i][0] = rs.getString(1);
							data[i][1] = rs.getInt(2);
							data[i][2] = rs.getInt(3);
							data[i][3] = rs.getInt(4);
							data[i][4] = rs.getInt(5);
							data[i][5] = rs.getInt(6);
							data[i][6] = rs.getInt(7);
							data[i][7] = rs.getInt(8);
							data[i][8] = rs.getInt(9);
							i++;
						}
						qTable = new QueryTable(data, colhead);
						qTable.setVisible(true);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		String clubsNumsql = "select count(clubname) from club where clubid<>0";
		int clubcount = 0;
		try {
			ResultSet rs = st.executeQuery(clubsNumsql);
			while (rs.next()) {
				clubcount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] allclubs = new String[clubcount];
		String allclubssql = "select clubname from club where clubid<>0";
		try {
			ResultSet rs = st.executeQuery(allclubssql);
			int i = 0;
			while (rs.next()) {
				allclubs[i] = rs.getString(1);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		teamList1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		teamList1.setModel(new javax.swing.DefaultComboBoxModel(allclubs));
		jPanel1.add(teamList1);
		teamList1.setBounds(20, 190, 110, 38);

		teamvsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		teamvsLabel.setText("VS");
		jPanel1.add(teamvsLabel);
		teamvsLabel.setBounds(190, 190, 40, 32);

		teamList2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		teamList2.setModel(new javax.swing.DefaultComboBoxModel(allclubs));
		jPanel1.add(teamList2);
		teamList2.setBounds(280, 190, 110, 38);

		findTeamVs.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		findTeamVs.setText("Find");
		jPanel1.add(findTeamVs);
		findTeamVs.setBounds(420, 190, 90, 41);
		findTeamVs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try {
					statement = con
							.prepareCall("{call TEAM_VS_TEAM_STAT(?,?,?,?,?,?,?,?,?)}");
					statement.setString(1, (String) teamList1.getSelectedItem());
					statement.setString(2, (String) teamList2.getSelectedItem());
					statement.registerOutParameter(3, Types.INTEGER);
					statement.registerOutParameter(4, Types.INTEGER);
					statement.registerOutParameter(5, Types.INTEGER);
					statement.registerOutParameter(6, Types.INTEGER);
					statement.registerOutParameter(7, Types.INTEGER);
					statement.registerOutParameter(8, Types.INTEGER);
					statement.registerOutParameter(9, Types.INTEGER);
					statement.execute();
					int matchPlayed = statement.getInt(3);
					int win1 = statement.getInt(4);
					int win2 = statement.getInt(5);
					int draw = statement.getInt(6);
					int goal1 = statement.getInt(7);
					int goal2 = statement.getInt(8);
					int errflag = statement.getInt(9);

					if (errflag == 0) {
						teamVsteamFrame = new TeamVsFrame((String) teamList1
								.getSelectedItem(), (String) teamList2
								.getSelectedItem(), win1, win2, goal1, goal2,
								draw, matchPlayed, con, st);
						teamVsteamFrame.setVisible(true);
					} else if (errflag == 1) {
						JOptionPane.showMessageDialog(null,
								"Same teams are not to be compared");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		String playersNumsql = "select count(playername) from player where playerid<>0";
		int playercount = 0;
		try {
			ResultSet rs = st.executeQuery(playersNumsql);
			while (rs.next()) {
				playercount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] allplayers = new String[playercount];
		String allplayerssql = "select playername from player where playerid<>0";
		try {
			ResultSet rs = st.executeQuery(allplayerssql);
			int i = 0;
			while (rs.next()) {
				allplayers[i] = rs.getString(1);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		playerList1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		playerList1.setModel(new javax.swing.DefaultComboBoxModel(allplayers));
		jPanel1.add(playerList1);
		playerList1.setBounds(20, 260, 110, 38);

		playerVsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		playerVsLabel.setText("VS");
		jPanel1.add(playerVsLabel);
		playerVsLabel.setBounds(190, 260, 40, 30);

		playerList2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		playerList2.setModel(new javax.swing.DefaultComboBoxModel(allplayers));
		jPanel1.add(playerList2);
		playerList2.setBounds(280, 260, 111, 38);

		playerVsButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		playerVsButton.setText("Find");
		jPanel1.add(playerVsButton);
		playerVsButton.setBounds(420, 260, 90, 41);
		playerVsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try {
					statement = con
							.prepareCall("{call PLAYER_VS_PLAYER_STAT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					String player1 = (String) playerList1.getSelectedItem();
					String player2 = (String) playerList2.getSelectedItem();
					statement.setString(1, player1);
					statement.setString(2, player2);
					statement.registerOutParameter(3, Types.VARCHAR);
					statement.registerOutParameter(4, Types.VARCHAR);
					statement.registerOutParameter(5, Types.INTEGER);
					statement.registerOutParameter(6, Types.INTEGER);
					statement.registerOutParameter(7, Types.INTEGER);
					statement.registerOutParameter(8, Types.INTEGER);
					statement.registerOutParameter(9, Types.INTEGER);
					statement.registerOutParameter(10, Types.INTEGER);
					statement.registerOutParameter(11, Types.NUMERIC);
					statement.registerOutParameter(12, Types.NUMERIC);
					statement.registerOutParameter(13, Types.INTEGER);
					statement.registerOutParameter(14, Types.INTEGER);
					statement.execute();
					String pos1 = statement.getString(3);
					String pos2 = statement.getString(4);
					int match1 = statement.getInt(5);
					int match2 = statement.getInt(6);
					int goal1 = statement.getInt(7);
					int goal2 = statement.getInt(8);
					int assist1 = statement.getInt(9);
					int assist2 = statement.getInt(10);
					double pass1 = statement.getDouble(11);
					double pass2 = statement.getDouble(12);
					int save1 = statement.getInt(13);
					int save2 = statement.getInt(14);

					if (player1.equals(player2)) {
						JOptionPane.showMessageDialog(null,
								"Same players are not to be compared");
					} else {
						playerVsplayerFrame = new PlayerVsFrame(
								(String) playerList1.getSelectedItem(),
								(String) playerList2.getSelectedItem(), pos1,
								pos2, match1, match2, goal1, goal2, assist1,
								assist2, pass1, pass2, save1, save2, con, st);
						playerVsplayerFrame.setVisible(true);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		playerList.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		playerList.setModel(new javax.swing.DefaultComboBoxModel(allplayers));
		jPanel1.add(playerList);
		playerList.setBounds(20, 330, 110, 38);

		vsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		vsLabel.setText("VS");
		jPanel1.add(vsLabel);
		vsLabel.setBounds(190, 330, 28, 32);

		clubList.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		clubList.setModel(new javax.swing.DefaultComboBoxModel(allclubs));
		jPanel1.add(clubList);
		clubList.setBounds(280, 330, 111, 38);

		playerVSTeamButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		playerVSTeamButton.setText("Find");
		jPanel1.add(playerVSTeamButton);
		playerVSTeamButton.setBounds(420, 330, 90, 41);
		playerVSTeamButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				try {
					statement = con
							.prepareCall("{call PLAYER_VS_TEAM_STAT(?,?,?,?)}");
					statement.setString(1,
							(String) playerList.getSelectedItem());
					statement.setString(2, (String) clubList.getSelectedItem());
					statement.registerOutParameter(3, Types.INTEGER);
					statement.registerOutParameter(4, Types.INTEGER);
					statement.execute();
					String player = (String) playerList.getSelectedItem();
					String club = (String) clubList.getSelectedItem();
					int goals = statement.getInt(3);
					int assists = statement.getInt(4);

					playerVsTeamFrame = new PlayerVsTeam(player, club, goals,
							assists, con, st);
					playerVsTeamFrame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		bestPlayerLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		bestPlayerLabel.setText("Best Player");
		jPanel1.add(bestPlayerLabel);
		bestPlayerLabel.setBounds(20, 400, 120, 32);

		bestVsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		bestVsLabel.setText("VS");
		jPanel1.add(bestVsLabel);
		bestVsLabel.setBounds(190, 400, 40, 32);

		bestVsclubList.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		bestVsclubList.setModel(new javax.swing.DefaultComboBoxModel(allclubs));
		jPanel1.add(bestVsclubList);
		bestVsclubList.setBounds(280, 400, 110, 38);

		bestFindButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		bestFindButton.setText("Find");
		jPanel1.add(bestFindButton);
		bestFindButton.setBounds(420, 400, 90, 41);
		bestFindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CallableStatement statement = null;
				String nilString = "nil";
				try {
					statement = con
							.prepareCall("{call BEST_PLAYER_VS_TEAM(?,?,?,?)}");
					statement.setString(1,
							(String) bestVsclubList.getSelectedItem());
					statement.setString(2, nilString);
					statement.registerOutParameter(3, Types.VARCHAR);
					statement.registerOutParameter(4, Types.VARCHAR);
					statement.execute();
					String player = statement.getString(3);
					String goalscount = statement.getString(4);
					System.out.println(player + " " + goalscount);

					bestframe = new BestVsTeamFrame(player, goalscount);
					bestframe.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		showLeaderboardButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		showLeaderboardButton.setText("Show Leaderboard");
		jPanel1.add(showLeaderboardButton);
		showLeaderboardButton.setBounds(20, 460, 240, 41);
		showLeaderboardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String goalleaderstr = "select * from (select p.playerid,  sum(goalscored) from match_perf mp join player p on(p.playerid=mp.playerid)  where matchid=any(select matchid from seasonstat where seasonid=(select seasonid from season where sysdate>=startdate and sysdate<=enddate)) and mp.playerid!=0 group by p.playerid order by sum(goalscored) desc , sum(assists) desc , mp.playerid) MYTABLE  where rownum<=10";
				String[][] playersgoaldata = new String[10][2];
				String[] playersids = new String[10];
				try {
					ResultSet rs = st.executeQuery(goalleaderstr);
					int i = 0;
					while (rs.next()) {
						playersids[i] = rs.getString(1);
						playersgoaldata[i][1] = rs.getString(2);
						i++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// for(int i=0;i<10;i++)
				// System.out.println(playersids[i]+ " " +playersdata[i][1]);

				ResultSet rs;
				for (int i = 0; i < 10; i++) {
					String playersnamestr = "select playername from player where playerid="
							+ playersids[i];
					try {
						rs = st.executeQuery(playersnamestr);
						while (rs.next()) {
							playersgoaldata[i][0] = rs.getString(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				for (int i = 0; i < 10; i++)
					System.out.println(playersgoaldata[i][0]+ " " + playersgoaldata[i][1]);
				
				
				//asssistsleaderboard
				System.out.println("assist board");
				String assistleaderstr = "select * from (select p.playerid,  sum(assists) from match_perf mp join player p on(p.playerid=mp.playerid)  where matchid=any(select matchid from seasonstat where seasonid=(select seasonid from season where sysdate>=startdate and sysdate<=enddate)) and mp.playerid!=0 group by p.playerid order by  sum(assists) desc , sum(goalscored) desc , mp.playerid) MYTABLE  where rownum<=10";
				String[][] playersassistdata = new String[10][2];
				String[] playersassistids = new String[10];
				try {
					ResultSet rs1 = st.executeQuery(assistleaderstr);
					int i = 0;
					while (rs1.next()) {
						playersassistids[i] = rs1.getString(1);
						playersassistdata[i][1] = rs1.getString(2);
						i++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// for(int i=0;i<10;i++)
				// System.out.println(playersids[i]+ " " +playersdata[i][1]);

				ResultSet rs1;
				for (int i = 0; i < 10; i++) {
					String playersnamestr = "select playername from player where playerid="
							+ playersassistids[i];
					try {
						rs1 = st.executeQuery(playersnamestr);
						while (rs1.next()) {
							playersassistdata[i][0] = rs1.getString(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				for (int i = 0; i < 10; i++)
					System.out.println(playersassistdata[i][0]+ " " + playersassistdata[i][1]);
				
				leaders = new LeaderboardFrame(playersgoaldata,playersassistdata);
				leaders.setVisible(true);
			}
		});

		jLabel1.setIcon(new javax.swing.ImageIcon(
				"E:\\BUET\\Level 3 Term 1\\CSE 304\\project\\query.jpg")); // NOI18N
		jPanel1.add(jLabel1);
		jLabel1.setBounds(0, 0, 960, 540);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 960,
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
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(QueryForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(QueryForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(QueryForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(QueryForm.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new QueryForm().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton bestFindButton;
	private javax.swing.JLabel bestPlayerLabel;
	private javax.swing.JLabel bestVsLabel;
	private javax.swing.JComboBox bestVsclubList;
	private javax.swing.JButton closeButton;
	private javax.swing.JComboBox clubList;
	private javax.swing.JLabel clubRankingLabel;
	private javax.swing.JComboBox countryList;
	private javax.swing.JButton findClubRanking;
	private javax.swing.JButton findTeamVs;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JComboBox playerList;
	private javax.swing.JComboBox playerList1;
	private javax.swing.JComboBox playerList2;
	private javax.swing.JButton playerVSTeamButton;
	private javax.swing.JButton playerVsButton;
	private javax.swing.JLabel playerVsLabel;
	private javax.swing.JLabel projNameLabel;
	private javax.swing.JButton showLeaderboardButton;
	private javax.swing.JButton showallClubData;
	private javax.swing.JComboBox teamList1;
	private javax.swing.JComboBox teamList2;
	private javax.swing.JLabel teamvsLabel;
	private javax.swing.JLabel vsLabel;
	private QueryTable qTable;
	private TeamVsFrame teamVsteamFrame;
	private PlayerVsFrame playerVsplayerFrame;
	private PlayerVsTeam playerVsTeamFrame;
	private BestVsTeamFrame bestframe;
	private LeaderboardFrame leaders;
	// End of variables declaration
}
