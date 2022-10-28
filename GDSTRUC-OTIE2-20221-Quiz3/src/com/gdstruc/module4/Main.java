package com.gdstruc.module4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int idCount = 1; // Keeps count of the ID of each players

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int turns = 1, gamesMade = 0;

        // Largest possible amount of players inside a queue would be 11
        // (1st iteration max is 4 while the 2nd iteration's max is 7)
        ArrayQueue arrayQueue = new ArrayQueue(11);

        //Loop until 10 games are made.
        while (gamesMade <= 10) {
            System.out.println("Turn " + turns);
            System.out.println("Matches found:" + gamesMade);
            System.out.println();

            int numOfPlayers = r.nextInt(7) + 1;

            // Add players to queue.
            addPlayersToQueue(arrayQueue, numOfPlayers);

            System.out.println("=======================================");

            System.out.println("Players inside the queue: ");
            arrayQueue.printQueue();

            if (arrayQueue.size() >= 5) {
                dequeuePlayers(arrayQueue);
                gamesMade++;
            }

            System.out.println("press ENTER to continue.");
            System.out.println("=======================================");

            s.nextLine();

            turns++;
        }

    s.close();

    }

    //  Add 4-7 players to the array
    public static void addPlayersToQueue(ArrayQueue queue, int amount) {
        String[] playerName = {"Hajime", "Mahiru", "Nanami", "Peko", "Mikan", "Soda", "Tanaka", "Nagito",
                "Nekomaru", "Akane", "Kuzuryu", "Ibuki", "\"Byakuya\"", "Teruteru", "Hiyoko", "Sonia"};
        Random r = new Random();

        for (int i = 0; i < amount; i++) {
            queue.enqueue(new Player(idCount, playerName[r.nextInt(16)], r.nextInt(1000) + 1));
            idCount++;
        }
    }

    //dequeue 5 players in the queue
    public static void dequeuePlayers(ArrayQueue queue) {
        while (queue.size() >= 5) {
            System.out.println("==========Match Initialized!==========");
            System.out.println("5 Players have been detected.");
            System.out.println("Dequeuing 5 players...");
            System.out.println("======================================");
            for (int i = 0; i < 5; i++)
                queue.dequeue();

        }
    }
}
