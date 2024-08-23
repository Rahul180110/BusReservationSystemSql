package BusReserve;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Date;

public class Booking {
    Booking() throws Exception{
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the PassangerId");
        int id=ob.nextInt();
        ob.nextLine();
        System.out.println("Enter the passanger Name");
        String name=ob.nextLine();
        System.out.println("Enter the BusNo to book");
        int busno=ob.nextInt();
        System.out.println("Enter the No of tickets");
        int ticket=ob.nextInt();
        System.out.println("Enter the date in given format dd-mm-yyyy");
        String date1=ob.next();
        Date date=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/BusReservation","root","free@fire");
        String qry1="select Capacity from Bus where BusNo="+busno+"";
        String qry2="select sum(tickets) from Booking where BusNo="+busno+" and date1='"+new java.sql.Date(date.getTime())+"'";
        Statement st=cn.createStatement();
        Statement st1=cn.createStatement();
        ResultSet rs=st.executeQuery(qry1);
        ResultSet rs1=st1.executeQuery(qry2);
        int a=0;
        int total=0;
        if(rs1.next()){
            total= rs1.getInt(1);
        }
        if(rs.next()) {
            int capacity = rs.getInt(1);
            System.out.println("total capacity is "+capacity);
            System.out.println("booked seats"+total);
            int available=capacity-total;
//            String seats="";
//            if(capacity==available){
//                seats="0-";
//                seats+=ticket;
//            }
//            else {
//                seats+=total+1;
//                seats+="-";
//                seats+=total+ticket;
//            }
            if(available>ticket){
                String qry="insert into Booking values(?,?,?,?,?)";
                PreparedStatement ps=cn.prepareStatement(qry);
                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setInt(3,busno);
                ps.setInt(4,ticket);
                ps.setDate(5,new java.sql.Date(date.getTime()));
//                ps.setString(6,seats);
                a=ps.executeUpdate();
//                int fixcapacity=capacity-total-ticket;
//                String qry3="update Bus set Capacity=? where BusNo=?";
//                PreparedStatement pst1=cn.prepareStatement(qry3);
//                pst1.setInt(1,fixcapacity);
//                pst1.setInt(2,busno);
//                pst1.executeUpdate();
            }
        }
        if(a>0){
            System.out.println("Booked suceesfully");
        }
        else {
            System.out.println("Booking unsuccessfull try another bus or date");
        }
    }
}
