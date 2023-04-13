package org.example;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Chek-in date (dd/mm/yyyy): ");
            Date chekIn = sdf.parse(sc.next());
            System.out.print("Chek-out date (dd/mm/yyyy): ");
            Date chekOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, chekIn, chekOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Chek-in date (dd/mm/yyyy): ");
            chekIn = sdf.parse(sc.next());
            System.out.print("Chek-out date (dd/mm/yyyy): ");
            chekOut = sdf.parse(sc.next());

            reservation.updateDates(chekIn, chekOut);
            System.out.println("Reservation: " + reservation);
        }
        catch(ParseException e){
            System.out.println("Invalid date format");
        }
        catch(DomainException e){
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();
    }
}