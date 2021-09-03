package drivetowork;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ben
 */
public class Console {

    private static char[][] screen = new char[25][40];

    public static Scanner scan;

    public static int[] getSize() {
        return new int[]{screen[0].length, screen.length};
    }

    public static void init() {
        scan = new Scanner(System.in);
        clear();
    }

    public static void clear() {
        for (int y = 0; y < screen.length; y++) {
            for (int x = 0; x < screen[0].length; x++) {
                screen[y][x] = ' ';
            }
        }
        System.out.println("\033[H\033[2J");
    }

    public static void write(int x, int y, String str, boolean print) {
        int index = 0;
        int xOffset = 0;
        int yOffset = 0;
        fixString(str, x, y);
        while (index < str.length()) {
            char a = str.charAt(index);
            if (a == '~') {
                yOffset++;
                index++;
                continue;
            }
            if (a == '`') {
                xOffset = 0;
                index++;
                continue;
            }
            if (xOffset + x > screen[y].length - 1) {
                xOffset = 0;
                yOffset++;
                continue;
            }
            screen[y + yOffset][x + xOffset] = a;
            index++;
            xOffset++;
        }
        if (print) {
            print();
        }
    }

    private static void fixString(String str, int x, int y) {
        String[] words = str.split(" ");
        String finalStr = "";
    }

    public static void print() {
        System.out.println("\033[H\033[2J");
        for (int a = 0; a < screen.length; a++) {
            for (int b = 0; b < screen[0].length; b++) {
                System.out.print(screen[a][b]);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.print('\n');
        }
    }

    public static void set(char[][] screen) {
        Console.screen = screen;
        print();
    }

    public static void waitForInput() {
        write(0, getSize()[1] - 1, "[Press Enter]", true);
        scan.nextLine();
    }

}
