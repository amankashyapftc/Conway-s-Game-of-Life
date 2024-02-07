package org.example;
import java.util.Scanner;

public class InputOutput {

    public InputOutput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        System.out.print("Enter the seeding percentage (1-100): ");
        int seedingPercentage = scanner.nextInt();

        Board board = new Board(rows, cols);

        board.seedRandomCells(seedingPercentage, rows, cols);

        System.out.println("Initial Generation:");
        board.print();

        boolean gameRunning = true;

        int genration = 1;
        try {
            while (gameRunning) {
                board.nextGeneration();
                System.out.println("Generation " + genration++ + ":");
                board.print();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (board.countAliveCells() == 0) {
                    System.out.println("All cells are dead. Game Over!");
                    gameRunning = false;
                }
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


        scanner.close();
    }
}