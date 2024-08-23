package BusReserve;
import java.sql.*;
import java.util.*;
public class view {
    view() throws Exception{
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter 1->Bus detail 2->Booking detail 3->passnger detail");
        Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/BusReservation","root","free@fire");
        Statement st=cn.createStatement();
        int decide=ob.nextInt();
        if(decide==1)
        {
           String qry="select * from Bus";
           ResultSet rs=st.executeQuery(qry);
           System.out.println("BUSNO\t AC\t\tCAPACITY");
           while (rs.next()){
               boolean ac=rs.getBoolean(3);
               if(ac){
                   System.out.println(rs.getInt(1)+"\t\tAC BUS\t"+rs.getInt(2));
               }
               else {
                   System.out.println(rs.getInt(1)+"\tNON AC\t"+rs.getInt(2));
               }

           }
        }
        else if (decide==2)
        {
            String qry="select * from Booking";
            ResultSet rs= st.executeQuery(qry);
            System.out.println("id\t Name\t busno\t tickets \t Date");
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+ rs.getInt(3) +"\t\t"+ rs.getInt(4)+"\t\t"+ rs.getDate(5));
            }

        } else if (decide==3)
        {
            System.out.println("Paasanger id");
            int id=ob.nextInt();
            String qry="select * from Booking where Passangerid="+id+"";
            ResultSet rs=st.executeQuery(qry);
            System.out.println("id\t Name\t busno\t tickets \t Date");
            while (rs.next()){
                System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+ rs.getInt(3) +"\t\t"+ rs.getInt(4)+"\t\t"+ rs.getDate(5));
            }

        }
        else
        {
            System.out.println("enter 1 or 2 or 2");
        }
    }
}
