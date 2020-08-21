import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCUPDATEDATA {
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
					String sql="Update User SET Password=?,FullName=?,Email=? where UserName=?";
					PreparedStatement pstmt=con.prepareStatement(sql);
					pstmt.setString(1,"123456789");
					pstmt.setString(2,"Su SU AUng Lay");
					pstmt.setString(3,"susu@facebook.com");
					pstmt.setString(4,"susu");
					
				int count=pstmt.executeUpdate();
				if(count>0) {
					System.out.println("Update success .");
				}else {
					System.out.println("can't update .");
				}
					
				}
			}catch(Exception e) {
				System.out.println("error"+e.getMessage());
			}

		}

}
