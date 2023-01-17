/**************
Ruben Bautista
CS 56 (Java)
Project 2
September 22, 2021
***************/
package rankingnameproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RankingNameProject {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String gender;
        int year;
        
        do{
        System.out.print("Enter year: ");
        year = scan.nextInt();
        if(year < 2001 || year > 2010){
            System.out.println("Invalid entry, please enter a year between 2001 and 2010 (Inclusive)");
        }
        }while(year < 2001 || year > 2010);
        scan.nextLine();
        do{
            System.out.print("Enter gender: ");
            gender = scan.nextLine();
            if(!gender.equalsIgnoreCase("F") && !gender.equalsIgnoreCase("M")){
                System.out.println("Invalid entry, please enter M or F");
            }
        }while(!gender.equalsIgnoreCase("F") && !gender.equalsIgnoreCase("M"));
        
        System.out.print("Enter name: ");
        String name = scan.nextLine();
            
        File record = new File("babynamesranking" + year + ".txt");
        if(!record.exists()){
            System.out.println("No record for " + year);
            System.exit(1);
        }
        
        int rank = 0;
        Scanner check = new Scanner(record);
        while(check.hasNext()){
            String curr = check.nextLine();
            String[] pl = curr.split(" ");
            if(gender.equalsIgnoreCase("M") && pl[1].equalsIgnoreCase(name)){
                rank = Integer.parseInt(pl[0]);
                System.out.println("\n" + name + " is ranked #" + rank + " in the year " + year);
                System.exit(0);
            }
            if(gender.equalsIgnoreCase("F") && pl[3].equalsIgnoreCase(name)){
                rank = Integer.parseInt(pl[0]);
                System.out.println("\n" + name + " is ranked #" + rank + " in the year " + year);
                System.exit(0);
            }
        }
        System.out.println("\nThe name " + name + " is not ranked in the year " + year);
    }
}
