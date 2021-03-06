package drivetowork;

import static drivetowork.Console.scan;

/**
 * @author Ben
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console.init();
        int[] size = Console.getSize();
        Console.write(size[0] / 2, size[1] / 2, "--BEEP BEEP BEEP--", false);
        Console.waitForInput();
        Console.clear();
        Console.write(0, 0, "It's your alarm clock. You awake to see that it's 7, you have to be in to work  by 9.", false);
        Console.waitForInput();
        Console.clear();
        Console.write(0, 0, "You throw on you cloths and hurry to    your car, it's raining.~`You must take the quickest path to work,but be careful.", false);
        Console.waitForInput();

        game();
    }

    public static void game() {
        int timeTaken = 0;
        int maxTimeAllowed = 120;
        int scene = 0;
        int selection = 0;
        int percent1 = 0;
        int percent2 = 0;
        int percent3 = 0;
        while (scene != 5) {
            java.util.Random rand = new java.util.Random();
            percent1 = rand.nextInt(15 - 5) + 5;
            percent2 = rand.nextInt(45 - 40) + 40;
            percent3 = rand.nextInt(65 - 50) + 50;
            String p1 = percent1 + "";
            if (percent1 < 10) {
                p1 = "0" + p1 + "%";
            } else {
                p1 = p1 + "%";
            }
            String p2 = percent2 + "";
            if (percent2 < 10) {
                p2 = "0" + p2 + "%";
            } else {
                p2 = p2 + "%";
            }
            String p3 = percent3 + "";
            if (percent3 < 10) {
                p3 = "0" + p3 + "%";
            } else {
                p3 = p3 + "%";
            }
            Console.set(pickScreen(p1, p2, p3));
            System.out.print("left?, forward?, right?: ");
            String choice = scan.nextLine();
            choice = choice.toLowerCase();
            switch (choice) {
                case "1": {
                    selection = -1;
                    break;
                }
                case "3": {
                    selection = 1;
                    break;
                }
                case "2": {
                    selection = 0;
                    break;
                }
            }
            switch (selection) {
                case -1: {
                    timeTaken += 20;
                    if (rand.nextInt(100) < percent1) {
                        scene = -1;
                    }
                    break;
                }
                case 0: {
                    timeTaken += 15;
                    if (rand.nextInt(100) < percent2) {
                        scene = -1;
                    }
                    break;
                }
                case 1: {
                    timeTaken += 10;
                    if (rand.nextInt(100) < percent3) {
                        scene = -1;
                    }
                    break;
                }
            }
            if (scene == -1) {
                break;
            }
            scene++;
        }
        if (scene == -1) {
            gameOver(true, timeTaken, maxTimeAllowed);
        } else if (timeTaken > maxTimeAllowed) {
            gameOver(false, timeTaken, maxTimeAllowed);
        } else {
            win(timeTaken, maxTimeAllowed);
        }
    }

    public static void gameOver(boolean death, int time, int max) {
        if (death) {
            Console.clear();
            Console.write(0, 0, "It's not your fault, the road was slick and foggy. You      couldn't have seen that tree.~~`You didn't make it.", false);
            Console.waitForInput();
            System.exit(0);
        } else {
            Console.clear();
            Console.write(0, 0, "Despite all the danger you putyourself through , you were late~~`You boss fired you.~~`Your time was: " + time + "/" + max, false);
            Console.waitForInput();
            System.exit(0);
        }
    }

    public static void win(int time, int max) {
        Console.clear();
        Console.write(0, 0, "You made it to work on time,  despite the dangers.~`Your time was: " + time + "/" + max, false);
        Console.waitForInput();
        System.exit(0);
    }

    public static char[][] pickScreen(String p1, String p2, String p3) {
        char[] a = p1.toCharArray();
        char[] b = p2.toCharArray();
        char[] c = p3.toCharArray();
        char[][] screen1 = new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '/', '-', '-', '-', '-', '-', '\\', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', '\\', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', '\\', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', 'V', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', '2', '0', 'm', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', '1', '5', 'm', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', a[0], a[1], a[2], ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', b[0], b[1], b[2], ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/'},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '/', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', '/'},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', '/', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', ' ', '|', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', '1', '0', 'm', '|', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', '/', ' ', ' ', ' ', '/', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', c[0], c[1], c[2], '|', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' '},
            {' ', '|', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|', '|', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', '|', ' '}};
        char[][] screen2 = new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        char[][] screen3 = new char[][]{
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        java.util.Random rand = new java.util.Random();
        switch (/*rand.nextInt(2)*/0) {
            case 0:
                return screen1;
            case 1:
                return screen2;
            case 2:
                return screen3;
            default:
                return screen1;
        }
    }

}
