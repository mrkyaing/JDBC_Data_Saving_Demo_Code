import java.sql.*;

public class JDBCSAVEDATA {
	//1 define db url ,user ,pass ,db driver
	private final static String url="jdbc:mysql://localhost/SampleDB";
	private final static String dbdriver="com.mysql.cj.jdbc.Driver";
	private final static String user="root";
	private final static String password="root@123";
	public static void main(String[] args) {
		try {
			Class.forName(dbdriver);
			Connection con;
			con=DriverManager.getConnection(url, user, password);
			if(con!=null) {
				System.out.println("connection is ok,");
				String sql="insert into User(UserName,Password,FullName,Email) values(?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(sql);
				pstmt.setString(1,"myamya");
				pstmt.setString(2,"myamya@123@#$%^&");
				pstmt.setString(3,"Mya Mya Myint Mo Oo");
				pstmt.setString(4,"myama@gmailcom");
				
			int count=pstmt.executeUpdate();
			if(count>0) {
				System.out.println("save success .");
			}else {
				System.out.println("can't save .");
			}
				
			}
		}catch(Exception e) {
			System.out.println("error"+e.getMessage());
		}

	}

}
