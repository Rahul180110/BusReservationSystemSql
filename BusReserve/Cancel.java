    package BusReserve;
    import java.sql.*;
    import java.util.*;
    import java.text.SimpleDateFormat;
    import java.util.Date;

    public class Cancel  {
        Cancel() throws Exception{
           Scanner ob=new Scanner(System.in);
            System.out.println("Enter the passanger Name");
            String name=ob.nextLine();
            System.out.println("Enter the bus NO");
            int busno=ob.nextInt();
            System.out.println("enter the passanger id");
            int id=ob.nextInt();
            ob.nextLine();
            System.out.println("enter the date in following format dd-mm-yyyyy");
            String date1=ob.nextLine();
            System.out.println("name"+name+"id"+ id+ date1+busno);
            Date date2=new SimpleDateFormat("dd-MM-yyyy").parse(date1);
            Date date=new java.sql.Date(date2.getTime());
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/BusReservation","root","free@fire");
    //        Statement st=cn.createStatement();
    //        System.out.println("1");
            String qry="select * from Booking where Passangerid=? and pass_Name=? and BusNo=? and date1=? ;";
            PreparedStatement ps=cn.prepareStatement(qry);
            ps.setString(2,name);
            ps.setInt(3,busno);
            ps.setDate(4,new java.sql.Date(date2.getTime()));
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            int ticket=0;
            int capasity=0;
    //        System.out.println("2");
            if(rs.next())
            {
                ticket = rs.getInt(4);
                System.out.println(ticket);
                String qry2="select Capacity from Bus where BusNo=?";
                PreparedStatement pst=cn.prepareStatement(qry2);
                pst.setInt(1,busno);
                ResultSet rs1=pst.executeQuery();
                if(rs1.next()) {
                     capasity = rs1.getInt(1);
                    System.out.println(capasity);
                }
                String qry1="delete from Booking where pass_Name=? and BusNo=? and date1=? and Passangerid=?;";
                PreparedStatement pt=cn.prepareStatement(qry1);
                pt.setString(1,name);
                pt.setInt(2,busno);
                pt.setDate(3,new java.sql.Date(date2.getTime()));
                pt.setInt(4,id);
                int a=pt.executeUpdate();
                if(a>0){
                    int total=capasity+ticket;
//                    String fixcapacity="update Bus set Capacity="+total+" where BusNo="+busno+"";
//                    Statement st2=cn.createStatement();
//                    st2.executeUpdate(fixcapacity);
                    System.out.println("Cancel ticket successfully");
                }
                else {
                    System.out.println("can not cancel the ticket");
                }
            }
            else {
                System.out.println("Enter the correct details");
            }
        }
    }
