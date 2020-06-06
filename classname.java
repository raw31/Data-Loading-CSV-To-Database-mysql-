

import com.google.gson.Gson;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class classname {
	public static java.sql.Date convertdate(java.util.Date x){
        
        //java.util.Date utilDate = cal.getTime();
        java.sql.Date sqlDate = new java.sql.Date(x.getTime());
        return sqlDate;   
    }
	
	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		String line = "";  
		String splitBy = ","; 
		Connection dbCon = null;
		
		//String tst="INSERT INTO customer_invoice (acct_doc_header_id) VALUES (?);";
		String Insertqry="INSERT INTO tablename()";// insert query here 
		
		
		ArrayList<pojo>rows=new ArrayList<>();
		try{  
			
			br = new BufferedReader(new FileReader("CSV FILE PATH"));
			Class.forName("com.mysql.cj.jdbc.Driver");  
			 dbCon=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/project","USERNAME","PASSWORD"); // username password of your DB  
			 int i=0;
			Statement stmt=dbCon.createStatement(); 
			line=br.readLine();
			// We create array list of pojo object
			// Here we create object of pojo class and the onject have all attributes of our csv columns
			//Making object of pojo class with passing value of attributes will give us a row.
			//Then we push the pojo object in array list, hence making the the arraylist of pojo object (Info row wise)
			while ((line = br.readLine()) != null)   
			{  
				String[] inv = line.split(splitBy,-1);
				pojo tmp=new pojo(); // object of pojo class
				
				
				tmp.setAcct_doc_header_id(Integer.parseInt(inv[i++]));  //example 
				
						rows.add(tmp);
						i=0;
			
			} 
	
			PreparedStatement pstmt=null;
			pojo j;
			int rs;
			for(int k=0;k<rows.size();k++) {
		
				
				 j=rows.get(k);
				 Insertqry="INSERT INTO table_name (column_name) VALUES (?);";
				 pstmt=dbCon.prepareStatement(Insertqry);
			        
				 	//prepare the query statement by giving value of ? of query
				 	if (j.acct_doc_header_id==0) pstmt.setNull(1, Types.NULL);
			        else pstmt.setInt(1, j.column_name);
			        
			        
			        int rowsAffected = pstmt.executeUpdate();
			        
			}

			
			
			}
			catch(Exception e)
				{ 
				System.err.println("An Exception was caught!");
				e.printStackTrace(); 
				}
		finally {
			try {
				br.close();
				dbCon.close();
			}
			catch(IOException | SQLException e) {
				System.err.println("An Exception was caught!");
				e.printStackTrace(); 
			}
		}

	
	}
}
