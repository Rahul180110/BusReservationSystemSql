package BusReserve;
import java.sql.*;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ob=new Scanner(System.in);
        boolean decide=true;
        boolean maindecide=true;
        while (maindecide) {
            System.out.println("Enter 1->ADMIN 2->USER 3->Exit");
            int person = ob.nextInt();
            if (person == 1)
            {
                String password="Rahulcse";
                System.out.println("Enter the password");
                String pass=ob.next();
                boolean ad=true;
                if(pass.equals(password)) {
                    while (ad) {
                        System.out.println("Enter 1->ADD BUS 2->REMOVE BUS 3->exit");
                        int choice = ob.nextInt();
                        if (choice == 1) {
                            try {
                                Admin a = new Admin();
                                a.add();

                            }
                            catch (SQLIntegrityConstraintViolationException s){
                                System.out.println("BusNo is already exist");
                            }
                            catch (Exception e) {
                                System.out.println(e);
                            }

                        } else if (choice == 2) {
                            try {
                                Admin b = new Admin();
                                b.remove();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } else if (choice == 3) {
                            ad = false;

                        } else {
                            System.out.println("select ADD or REMOVE");
                        }
                    }
                    }
                else{
                        System.out.println("Invalid Check your password");
                    }

            }
            else if (person == 2)
            {
                while (decide) {
                    System.out.println("Enter 1->Booking 2->Cancel 3->View 4->Exit");
                    int case1 = ob.nextInt();
                    switch (case1) {
                        case 1:

                            try {
                                new Booking();
                            }
                            catch (InputMismatchException e){
                                System.out.println("input miss match check it");
                            }
                            catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 2:
                            try {
                                new Cancel();
                            } catch (Exception e) {
                                System.out.println(e);
                            }

                            break;
                        case 3:
                            try {
                                new view();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                            break;
                        case 4:
                            decide = false;
                            break;
                    }

                }
            } else if (person==3) {
                maindecide=false;
            } else {
                System.out.println("select ADMIN or USER");
            }
        }
    }

}
