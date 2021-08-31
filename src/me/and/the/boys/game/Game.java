package me.and.the.boys.game;

import me.and.the.boys.players.Player;
import me.and.the.boys.roles.*;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private PriorityQueue<Player> nightPhase = new PriorityQueue<>();
    private PriorityQueue<Player> nightPhaseCopy = new PriorityQueue<>();
    private Map<String, String> dayPhase = new HashMap<>();
    private Map<String, String> eventLog = new HashMap<>();
    private int nightTurns = 1;

    public void startNightPhase(){
        nightPhaseCopy.addAll(nightPhase);
        while (!nightPhaseCopy.isEmpty()) {
            Player player = nightPhaseCopy.poll();

            if (!player.getRole().isRecurring() && player.getRole().isHasTurns() && player.isAlive()){
                nightPhaseActions(player);
                player.getRole().setHasTurns(false);
            }

            if (player.getRole().isRecurring() && player.isAlive()) {
                nightPhaseActions(player);
            }
            System.out.println();
        }
        nightTurns++;
    }

    private void nightPhaseActions(Player player) {
        System.out.print(player.getName() + " what are you going to do: ");
        scanner.nextLine();
        String playerChoice = scanner.nextLine();
        System.out.println(player.getName() + " chose " + playerChoice);
        eventLog.put(player.getName(), playerChoice);
    }


    public void setUpGame(){

        System.out.println("Select 1 to add a new player\n" +
                "Select 2 to finish adding players");
        int choice = scanner.nextInt();
        int counter = 0;

        while (choice == 1){
            scanner.reset();

            if (counter > 0){
                System.out.println("Select 1 to add a new player\n" +
                        "Select 2 to finish adding players");
                choice = scanner.nextInt();
                if (choice != 1){
                    return;
                }
            }
            scanner.nextLine();

            newPlayer();
            counter++;
        }

    }

    private void newPlayer() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.println("Press 1 - Cupid\n" +
                "Press 2 - Fortune Teller\n" +
                "Press 3 - Healer\n" +
                "Press 4 - Hunter\n" +
                "Press 5 - Mayor\n" +
                "Press 6 - Red riding hood\n" +
                "Press 7 - Villager\n" +
                "Press 8 - Werewolf\n" +
                "Press 9 - Witch");
        System.out.println();
        System.out.print("Select a role for the player from the options above: ");

        int roleChoice = scanner.nextInt();

        Role role = null;

        switch (roleChoice){

            case 1:
                role = new Cupid();
                break;

            case 2:
                role = new FortuneTeller();
                break;

            case 3:
                role = new Healer();
                break;

            case 4:
                role = new Hunter();
                break;

            case 5:
                role = new Mayor();
                break;

            case 6:
                role = new RedHood();
                break;

            case 7:
                role = new Villager();
                break;

            case 8:
                role = new Werewolf();
                break;

            case 9:
                role = new Witch();
                break;
        }

        Player player = new Player(name, role);
        nightPhase.add(player);
    }

    public void printPlayers() {
        nightPhase.forEach(System.out::println);
    }

    public void printLog() {
        eventLog.forEach((key, value) -> System.out.println(key + " Did " + value));
    }

}
