package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bill {
	
		//insert to DB
	
public String insertBill(String userName, String userAddress, String userMobile, float units , float amount , float arrears , float finalBill) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			Connection con1 = con.connect();
			if(con1 == null) {
				
				return"DB connection is unsucessfull";
				
			}
			
			String query = "insert into bill values (?, ?, ?, ?, ? , ? , ? )";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1,0);
			preparedStmt.setString(2,userName);
			preparedStmt.setString(3,userAddress);
			preparedStmt.setString(4,userMobile);
			preparedStmt.setFloat(5,units);
			preparedStmt.setFloat(6,amount);
			preparedStmt.setFloat(7,arrears);
			preparedStmt.setFloat(8,finalBill);
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			output = "Data Inserted Successfully";
			
		}
		catch(Exception e) {
			
			output = "Not Inserted Sucessfully!";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}

				//view bill details
	
	public String readBill() {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return "Error while connecting to the database for reading";
				
			}
			
			//HTML table
			output = "<table border=\"1\">\r\n"
					+ "		<tr>\r\n"
					+ "			<th>User ID</th><th>User Name</th><th>user Address</th><th>User Mobile</th><th>Units</th><th>Amount</th><th>Arrears</th><th>Final Bill</th> <th>Update</th><th>Remove</th>\r\n"
					+ "		</tr>";
			
			String query = "select * from bills";
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			
			while (rs.next()) {
				
				Integer userID = rs.getInt("userID");
				String userName = rs.getString("userName");
				String userAddress = rs.getString("userAddress");
				String userMobile = rs.getString("userMobile");
				float units = rs.getFloat("units");
				float amount = rs.getFloat("amount");
				float arrears = rs.getFloat("arrears");
				float finalBill = rs.getFloat("finalBill");
				
				//add a row into the html table
				output += "<tr>"
						+ "			<td>" +userID+ "</td><td>" +userName+ "</td><td>" +userAddress+ "</td><td>" +userMobile+ "</td> <td>" +units+ "</td> <td>" +amount+ "</td> <td>" +arrears+ "</td> <td>" +finalBill+ "</td> "
						+ "			<td><form method='post' action='TotalBills.jsp'><input name='btnUpdate' type='submit' value='Update'><input name='userID' type='text' value='"+userID+"'><input name='userName' type='text' value='"+userName+"'><input name='useerAddress' type='text' value='"+userAddress+"'><input name='userMobile' type='number' value='"+userMobile+"'><input name='units' type='number' value='"+units+"'><input name='amount' type='number' value='"+amount+"'><input name='arrears' type='number' value='"+arrears+"'><input name='finalBill' type='number' value='"+finalBill+"'></form></td>"
					
						+ "		</tr>";
				
			}
			
			con1.close();
			
		
			output += "</table>";
			
			
			
		}
		catch(Exception e) {
			
			output = "Error while reading the items";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
							//update bill details
	
	public String updateBill(int userID, String userName, String userAddress, String userMobile , float units , float amount , float arrears , float finalBill  ) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for updating";
				
			}
			
			String query = "update bill set userName=?, userAddress=?, userMobile=? units=?, amount=?,arrears=?,finalBill=? where userID =?";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			
			preparedStmt.setString(1,userName);
			preparedStmt.setString(2,userAddress);
			preparedStmt.setString(3,userMobile);
			preparedStmt.setFloat(4, units);
			preparedStmt.setFloat(5, amount);
			preparedStmt.setFloat(6, arrears);
			preparedStmt.setFloat(7, finalBill);
			preparedStmt.setInt(8, userID);
			
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			output = "Updated Successfully";
			
		}
		catch(Exception e) {
			
			output = "Error while updating";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public String deleteBill(String userID) {
		
		String output = "";
		
		try {
			
			connection con = new connection();
			
			Connection con1 = con.connect();
			
			if(con1 == null) {
				
				return"Error while connecting to the databse for deleting";
				
			}
			
			String query = "delete from bill where userID = ? ";
			
			PreparedStatement preparedStmt = con1.prepareStatement(query);
			
			//binding values
			preparedStmt.setInt(1,Integer.parseInt(userID));
			
			//execute the statement
			preparedStmt.execute();
			con1.close();
			
			output = "Deleted Successfully";
			
		}
		catch(Exception e) {
			
			output = "Error while deleting";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}

}
