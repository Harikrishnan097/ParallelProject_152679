package com.ewallet.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ewallet.bean.AccountDetails;

public class EwalletDao {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	double balance;
	int flag = 0;
	String details;
	static int accno;
	int account_number;
	AccountDetails acdetails = new AccountDetails();
	public static Map<Integer, AccountDetails> map1 = new HashMap<Integer, AccountDetails>();
	public static List<String> transactions = new ArrayList<String>();

	public int login(String username, String password) {
		Connection conn = JdbcUtil.getConnection();
		Statement st;
		try {
			st = conn.createStatement();

			String select = "select customerdetails.username ,customerdetails.password,customerdetails.account_no from customerdetails,accountdetails  where customerdetails.account_no=accountdetails.account_no";
			st.executeQuery(select);

			ResultSet rs = st.executeQuery(select);

			while (rs.next()) {

				String uname = rs.getString("username");
				String pass = rs.getString("password");
				if (uname.equals(username) && pass.equals(password)) {
					// String select="select * from accountdetails";

					accno = rs.getInt("account_no");

					return 1;

				}

			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int createAccount(AccountDetails adetails) {

		Connection conn = JdbcUtil.getConnection();
		int account_no = adetails.getAccount_no();

		double balance = adetails.getBalance();

		int age = adetails.getDetails().getAge();
		String gender = adetails.getDetails().getGender();
		String customer_name = adetails.getDetails().getCustomer_name();
		String phone_number = adetails.getDetails().getPhone_number();
		String adhaar_number = adetails.getDetails().getAdhaar_number();
		String email_id = adetails.getDetails().getEmail_id();
		String username = adetails.getDetails().getUsername();
		String password = adetails.getDetails().getPassword();
		// int acno=adetails.getDetails().getAccount_no();
		String insert_query = "INSERT INTO accountdetails VALUES(?,?)";
		String insert_query2 = "INSERT INTO customerdetails  VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement pt = conn.prepareStatement(insert_query);
			PreparedStatement pt2 = conn.prepareStatement(insert_query2);
			pt.setLong(1, account_no);
			pt.setDouble(2, balance);
			pt2.setString(1, customer_name);
			pt2.setInt(2, age);
			pt2.setString(3, gender);
			pt2.setString(4, phone_number);
			pt2.setString(5, adhaar_number);
			pt2.setString(6, username);
			pt2.setString(7, password);
			pt2.setInt(8, account_no);

			pt2.execute();
			pt.execute();
			conn.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;

	}

	public int deposit(double amount) {

		account_number = accno;
		// System.out.println(account_number);
		Connection con = JdbcUtil.getConnection();

		try {
			String deposit = " THE AMOUNT" + amount + "IS DEPOSITED" + "\n";
			String insertq = "INSERT INTO Transaction values(?,?)";
			String Query = "update accountdetails SET balance= balance+? where account_no=?";
			PreparedStatement pstmt, pt2;

			pstmt = con.prepareStatement(Query);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, account_number);
			pstmt.execute();
			pt2 = con.prepareStatement(insertq);
			pt2.setLong(1, account_number);
			pt2.setString(2, deposit);
			pt2.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;

	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub

		account_number = accno;
		// System.out.println(account_number);
		Connection con = JdbcUtil.getConnection();

		try {
			Statement st = con.createStatement();
			String withdraw = " THE AMOUNT " + amount + "IS WITHDRAWN";
			String insertw = "INSERT INTO Transaction values(?,?)";

			String query = "select * from accountdetails where account_no='" + account_number + "'";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				balance = rs.getDouble("balance");

			}
			if (balance > amount) {
				String Query = "update accountdetails SET balance= balance-? where account_no=?";
				PreparedStatement pstmt, pt;
				pstmt = con.prepareStatement(Query);
				pstmt.setDouble(1, amount);
				pstmt.setInt(2, account_number);

				pt = con.prepareStatement(insertw);
				pt.setLong(1, account_number);
				pt.setString(2, withdraw);
				pstmt.executeUpdate();
				pt.execute();
				con.close();

				return 0;
			} else {
				System.out.println("amount exceeds");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}

	public void showbalance() {

		account_number = accno;

		Connection conn = JdbcUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String query = "select * from accountdetails where account_no='" + account_number + "'";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				balance = rs.getDouble("balance");

			}

			System.out.println("balance is" + balance);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int fundtransfer(int account_number2, double amount) {
		// TODO Auto-generated method stub

		Connection con = JdbcUtil.getConnection();
		account_number = accno;

		try {
			String fdt = " THE AMOUNT  " + amount + "  IS TRANSFERRED TO   " + account_number2;
			String insertfund = "INSERT INTO Transaction values(?,?)";
			String Query = "update accountdetails SET balance= balance+? where account_no=?";
			PreparedStatement pstmt, pt3;
			pstmt = con.prepareStatement(Query);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, account_number2);
			pstmt.execute();

			Statement st = con.createStatement();
			String query = "select * from accountdetails where account_no='" + account_number + "'";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				balance = rs.getDouble("balance");

			}
			if (balance > amount) {
				String fd = "update accountdetails SET balance= balance-? where account_no=?";

				pstmt = con.prepareStatement(fd);
				pstmt.setDouble(1, amount);
				pstmt.setInt(2, account_number);
				pt3 = con.prepareStatement(insertfund);
				pt3.setLong(1, account_number);
				pt3.setString(2, fdt);
				pt3.execute();
				pstmt.execute();
				con.close();
				return 0;
			} else {
				System.out.println("cant tansfer amount exceeds");

			}

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public void printtransaction() {
		account_number = accno;

		Connection conn = JdbcUtil.getConnection();
		try {
			Statement st = conn.createStatement();
			String query = "select * from transaction where account_no='" + account_number + "'";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.println();
				details = rs.getString("transactioninfo");
				System.out.println("the transactions are \n" + details);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
