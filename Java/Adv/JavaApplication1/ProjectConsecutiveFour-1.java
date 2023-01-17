/**************
Ruben Bautista
CS 56 (Java)
Project 1
September 11, 2021
***************/
import java.util.Scanner;

public class ProjectConsecutiveFour {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scan.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scan.nextInt();

        int[][] arr = new int[rows][columns];

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = (int)(Math.random()*10);
        
        if(isConsecutiveFour(arr) == false){
            System.out.print("There is no number that appears four times consecutively.\nFalse\n\n");
            display2D(arr);
        }
    }

    public static boolean isConsecutiveFour(int[][] values){
        for (int i = 0; i < values.length; i++){
            int current = values[i][0];
            int consecutiveCount = 0;

            for (int j = 0; j < values[i].length; j++){
                if (values[i][j] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4){
                        System.out.printf("Consecutive number is " + ANSI_RED + "%d.\n" + ANSI_RESET, current);
                        System.out.print("True\n\n");
                        display2D(values, current);
                        return true;
                    }
                } else {
                    current = values[i][j];
                    consecutiveCount = 1;
                }
            }
        }
        
        for (int j = 0; j < values[0].length; j++){
            int consecutiveCount = 0;
            int current = values[0][j];

            for (int i = 0; i < values.length; i++){
                if (values[i][j] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4){
                        System.out.printf("Consecutive number is " + ANSI_RED + "%d.\n" + ANSI_RESET, current);
                        System.out.print("True\n\n");
                        display2D(values, current);
                        return true;
                    }
                } else {
                    current = values[i][j];
                    consecutiveCount = 1;
                }
            }
        }
        
        for (int i = values.length - 1; i > 0; i--){
            int y = i;
            int x = 0;
            int consecutiveCount = 0;
            int current = values[y][x];
            
            
            while (y >= 0 && x <= values[0].length - 1) {
                if (values[y][x] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4){
                        System.out.printf("Consecutive number is " + ANSI_RED + "%d.\n" + ANSI_RESET, current);
                        System.out.print("True\n\n");
                        display2D(values, current);
                        return true;
                    }
                } else {
                    consecutiveCount = 1;
                    current = values[y][x];
                }
                x++;
                y--;
            }
        }
        
        for (int j = 0; j < values[0].length; j++) {
            int y = values.length - 1;
            int x = j;
            int consecutiveCount = 0;
            int current = values[y][x];

            while (x < values[0].length && y >= 0) {
                if (values[y][x] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4){
                        System.out.printf("Consecutive number is " + ANSI_RED + "%d.\n" + ANSI_RESET, current);
                        System.out.print("True\n\n");
                        display2D(values, current);
                        return true;
                    }
                } else {
                    consecutiveCount = 1;
                    current = values[y][x];
                }
                x++;
                y--;
            }
        }
        
        for (int j = values[0].length - 1; j > 0; j--) {
            int x = j;
            int y = values.length - 1;
            int current = values[y][x];
            int consecutiveCount = 0;

            while (x >= 0 && y >= 0) {
                if (values[y][x] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4){
                        System.out.printf("Consecutive number is " + ANSI_RED + "%d.\n" + ANSI_RESET, current);
                        System.out.print("True\n\n");
                        display2D(values, current);
                        return true;
                    }
                } else {
                    consecutiveCount = 1;
                    current = values[y][x];
                }
                x--;
                y--;
            }
        }
        
        for (int row = 1 ; row < values.length; row++) {
            int x = values[0].length - 1;
            int y = row;
            int consecutiveCount = 0;
            int current = values[y][x];

            while (y >= 0 && x >= 0) {
                if (values[y][x] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4){
                        System.out.printf("Consecutive number is " + ANSI_RED + "%d.\n" + ANSI_RESET, current);
                        System.out.print("True\n\n");
                        display2D(values, current);
                        return true;
                    }
                } else {
                    consecutiveCount = 1;
                    current = values[y][x];
                }
                x--;
                y--;
            }
        }
        return false;
    }
    
    public static void display2D(int[][] disArr){  
        for (int[] grid : disArr){
            for (int k = 0; k < grid.length; k++){
                System.out.printf("%-2d", grid[k]);
            }
            System.out.println("");
        }
    }
    
    public static void display2D(int[][] disArr, int current){
        int repeatNum = current;
        
        for (int[] grid : disArr){
            for (int k = 0; k < grid.length; k++){
                if(grid[k] == repeatNum){
                    System.out.printf(ANSI_RED + "%-2d" + ANSI_RESET, grid[k]);
                }else{
                    System.out.printf("%-2d", grid[k]);
                }
            }
            System.out.println("");
        }
    }
}
