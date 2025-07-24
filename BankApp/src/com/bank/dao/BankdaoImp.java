package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.connector.Connector;
import com.bank.dto.Customer;
import com.bank.dto.Transaction;
import com.bank.main.TransactionId;

public class BankdaoImp implements Bankdao {
	private Connection con = null;

	public BankdaoImp() {
		this.con = Connector.requestCon();
	}

	@Override
	public boolean insertTransaction(Transaction t) {
		// TODO Auto-generated method stub

		String Query = "Insert into passbook values (?,?,?,?,?,?,?)";
		int result = 0 ;
		try {
			con.setAutoCommit(false);
			PreparedStatement ps =con.prepareStatement(Query);
			ps.setLong(1, t.getTransactionId());
			ps.setLong(2, t.getUser());
			ps.setLong(3, t.getRec_acc());
			ps.setTimestamp(4, t.getDate());
			ps.setString(5, t.getTransaction());
			ps.setDouble(6, t.getAmount());
			ps.setDouble(7, t.getBalance());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if( result > 0) {
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List getTransaction(long user) {
		// TODO Auto-generated method stub
		List<Transaction> trans = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement ps =null;
		String Quary = "Select * from passbook where user_acc =?";
		try {
			ps = con.prepareStatement(Quary);
			ps.setLong(1, user);
			Transaction t1 = null;
			rs =  ps.executeQuery();
			while(rs.next()) {
				t1 = new Transaction();
				t1.setUser(rs.getLong(2));
				t1.setRec_acc(rs.getLong(3));
				t1.setTransactionId(rs.getLong(1));
				t1.setTransaction(rs.getString(5));
				t1.setAmount(rs.getDouble(6));
				t1.setBalance(rs.getDouble(7));	
				t1.setDate();
				trans.add(t1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trans;
	}

	@Override
	public boolean insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		String Query = "Insert into Customer values (?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setLong(1, c.getAccno());
			ps.setString(2, c.getName());
			ps.setLong(3, c.getPhone());
			ps.setString(4, c.getMail());
			ps.setDouble(5, c.getBal());
			ps.setInt(6, c.getPin());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result > 0;
	}

	@Override
	public Customer getCustomer(long accno, int pin) {
		// TODO Auto-generated method stub
		Customer c = null;
		String quary = "Select * from Customer where ACC_NO=? and PIN=?";
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement(quary);
			ps1.setLong(1, accno);
			ps1.setInt(2, pin);
			ResultSet rs = ps1.executeQuery();
			while (rs.next()) {
				c = new Customer();
				c.setAccno(rs.getLong(1));
				c.setBal(rs.getLong(5));
				c.setMail(rs.getString("MAIL"));
				c.setName(rs.getString("NAME"));
				c.setPhone(rs.getLong(3));
				c.setPin(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return c;
	}

	@Override
	public Customer getCustomer(long phone, String mail) {
		// TODO Auto-generated method stub
		String Quary = "Select * from Customer where phone=? and mail=?";
		ResultSet rs=null;
		Customer c = new Customer();
		try {
			PreparedStatement ps = con.prepareStatement(Quary);
			ps.setLong(1, phone);
			ps.setString(2, mail);
			rs = ps.executeQuery();
			if(rs !=null) {
					c.setAccno(rs.getLong(1));
					c.setName(rs.getString(2));
					c.setPhone(rs.getLong(3));
					c.setMail(rs.getString(4));
					c.setBal(rs.getDouble(5));
					c.setPhone(rs.getInt(6));
			}else {
				System.out.println("No Account Found!!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Customer getCustomer(long accno) {
		// TODO Auto-generated method stub
		String Quary = "Select * from Customer where Acc_no=?";
		ResultSet rs=null;
		Customer c = null;
		PreparedStatement ps =null;
		try {
			ps = con.prepareStatement(Quary);
			ps.setLong(1, accno);
			rs = ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
					c.setAccno(rs.getLong(1));
					c.setName(rs.getString(2));
					c.setPhone(rs.getLong(3));
					c.setMail(rs.getString(4));
					c.setBal(rs.getDouble(5));
					c.setPin(rs.getInt(6));
			}else {
				System.out.println("No Account Found!!!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		String Query = "update Customer set name=?, Phone=?,mail=?,balance=?,pin=? where acc_no=?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, c.getName());
			ps.setLong(2, c.getPhone());
			ps.setString(3, c.getMail());
			ps.setDouble(4, c.getBal());
			ps.setInt(5, c.getPin());
			ps.setLong(6, c.getAccno());
			result= ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result >0;
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		String Quary = "Delete from customer where acc_no=?";
		int result = 0 ;
		try {
			PreparedStatement ps = con.prepareStatement(Quary);
			ps.setLong(1, c.getAccno());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result>0;
	}

}
