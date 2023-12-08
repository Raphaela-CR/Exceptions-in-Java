package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {
    public static void main(String[] args) throws ParseException  {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Room number: ");
        Integer number = sc.nextInt();
        System.out.println("Check-in date: (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Check-Out date: (dd/MM/yyyy)");
        Date checkOut = sdf.parse(sc.next());

        if(!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-Out date must be after Check-in date.");
        } else {
           Reservation reservation = new Reservation(number, checkIn, checkOut);
           System.out.println(reservation);
        }
        
        sc.close();
    }
}
