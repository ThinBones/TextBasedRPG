
import java.util.Scanner;

public class Main {
    private static Scanner scan;
    private static Player  player;
    private static Enemy   currentEnemy;
    private static boolean gameOver;
    private static Inventory inventory;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        player = new Player("Player", 20, 20, 5, 5, 50);
        gameOver = false;
        inventory = new Inventory();

        while (!gameOver) {
            initializeMenus();
            generateEvent();
            checkWeight();
        }

        deathScreen();
    }

    public static void generateEvent() {
        int randomEvent = (int) ((Math.random() * 10) + 1);
        if (randomEvent < 5) {
            System.out.println("Enemy encounter!");
            generateEnemy();
            combatLoop();
        }
        else {
            System.out.println("You found loot!");
            generateLoot();
        }
    }

    public static void generateEnemy() {
        // generate random number for which enemy to spawn
        int randEnemy = (int) ((Math.random() * 10) + 1);
        if (randEnemy < 10) {
            currentEnemy = new SkeletonWarrior();
        }
        else {
            currentEnemy = new BlackBonedWarrior();
        }
    }

    public static void combatLoop() {
        System.out.println("A " + currentEnemy.getName() + " approaches!");
        System.out.println(currentEnemy.getName() + " has " + currentEnemy.getHealth() + " health.");
        System.out.println("Player has " + player.getHealth() + " health.");

        while (true) {
            // input section (player attacks or defends)
            boolean validInput = false;
    
            while (!validInput) {
                System.out.println("What would you like to do?");
                System.out.println("1. Attack\n2. Magic");
            
                int resp = scan.nextInt();
    
                switch (resp) {
                    case 1 -> {
                        player.attack(currentEnemy);
                        validInput = true;
                    }
                    case 2 -> {
                        magicMenu();
                        validInput = true;
                    }
                    default -> System.out.println("Not an option. Please try again.");
                }
            }

            // health check
            if (currentEnemy.getHealth() <= 0) {
                System.out.println(currentEnemy.getName() + " has died!");
                break;
            }

            System.out.println(currentEnemy.getName() + " has " + currentEnemy.getHealth() + " health remaining.");

            currentEnemy.attack(player);

            // health check
            if (player.getHealth() <= 0) {
                gameOver = true;
                break;
            }

            System.out.println(player.getName() + " has " + player.getHealth() + " health remaining.");
        }
    }


    public static void generateLoot() {
        int randomLoot = (int) ((Math.random() * 10) + 1);
        if (randomLoot == 1) {
            
        }
    }

    public static void checkWeight() {
        while (inventory.totalWeight() > player.getCarry()) {
            System.out.println("Please remove enough items to " +
            "be at or below the carry limit.");
            inventory.printAllItems();
            System.out.println("Select item to remove.");
            int resp = scan.nextInt();
            inventory.remove(inventory.get(resp));
        }
    }

    public static void initializeMenus() {
        System.out.println("What would you like to do?");
        System.out.println("1. Explore\n2. Equip\n3. Craft");
        boolean validInput = false;
        while (!validInput) {
           int resp = scan.nextInt();
            switch (resp) {
                case 1 -> {
                    validInput = true;
                    break;
                }
                case 2 -> {
                    equipScreen();
                    validInput = true;
                    break;
                }
                case 3 -> {
                    System.out.println("Not implemented");
                }
                default -> {
                    System.out.println("Not an option. Please try again.");
                }
            }         
        }
    }

    public static void equipScreen() {
        System.out.println("What item would you like to equip?");
        System.out.println("Type '-1' to exit.");
        inventory.printAllItems();
        int resp = scan.nextInt();
        boolean done = false;
        while (!done) {
            if (resp == -1) {
                done = true;
            }
            else if (inventory.get(resp).getIsEquipable()) {
                player.equip(inventory.get(resp));
            }
            else {
                System.out.println("Not an option. Try again.");
            }
        }
    }

    public static void magicMenu() {
        System.out.println("What spell would you like to cast?");
        System.out.println("Type '-1' to cast.");
        player.printAllSpells();
        int resp = scan.nextInt();
        boolean done = false;

        while (!done) {
            if (resp == -1) {
                done = true;
            }
            else if (player.getSpell(resp) == null) {
                throw new IllegalArgumentException("Not a spell.");
            }
            else {
                Spell tempSpell = player.getSpell(resp);

                // fix this, target needs to be able to vary
                // between player character & enemy character
                player.castSpell(tempSpell, null);
                done = true;
            }
        }
    }

    public static void deathScreen() {
        System.out.println("You died!");
        System.exit(0);
    }
}
