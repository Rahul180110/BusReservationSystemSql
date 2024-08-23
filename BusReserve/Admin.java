package BusReserve;
import java.util.*;
import java.sql.*;
public class Admin {
    public  void add() throws Exception{
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the Busno");
        int busno=ob.nextInt();
        System.out.println("Enter the ac satatus true or false");
        boolean ac=ob.nextBoolean();
        ob.nextLine();
        System.out.println("Enter the Capacity");
        int Capacity=ob.nextInt();
        String qry="insert into Bus values(?,?,?)";
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/BusReservation","root","free@fire");
        PreparedStatement pst= cn.prepareStatement(qry);
        pst.setInt(1,busno);
        pst.setInt(2,Capacity);
        pst.setBoolean(3,ac);
        int a=pst.executeUpdate();
        if(a>0){
            System.out.println("Bus updated successfully");
        }
        else {
            System.out.println("Bus update failure");
        }
    }
    public void remove() throws Exception{
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the Busno");
        int busno=ob.nextInt();
        System.out.println("Enter the ac satatus true or false");
        boolean ac=ob.nextBoolean();
        ob.nextLine();
        System.out.println("Enter the Capacity");
        int Capacity=ob.nextInt();
        String qry="delete from Bus where BusNo=? and Capacity=? and Ac=?";
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/BusReservation","root","free@fire");
        PreparedStatement pst=cn.prepareStatement(qry);
        pst.setInt(1,busno);
        pst.setBoolean(3,ac);
        pst.setInt(2,Capacity);
        int a=pst.executeUpdate();
        if(a>0){
            System.out.println("Bus deleted successfully");
        }
        else {
            System.out.println("Bus delete failure check bus details");
        }
    }
}
