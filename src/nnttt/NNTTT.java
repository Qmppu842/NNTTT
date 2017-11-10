/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nnttt;

import java.util.Scanner;

/**
 *
 * @author olindqvi
 */
public class NNTTT {

    /**
     * @param args the command line argumentsFI
     *
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Game test = new Game();
        test.setPlayer1toHuman();
        test.setPlayer2toHuman();
        test.init();
//        System.out.println(test.toString());
//        System.out.println();
//
//        Scanner input = new Scanner(System.in);
//
//        while (test.checkWinners().equals(StateOfSquare.EMPTY)) {
//            System.out.print("input ((x|o)xy): ");
//            String line = input.nextLine();
//            char vuor = line.charAt(0);
//            int x = line.charAt(1) - 48;
//            int y = line.charAt(2) - 48;
//
//            StateOfSquare t = StateOfSquare.EMPTY;
//            if (vuor == 'x') {
//                t = t.X;
//            } else {
//                t = t.O;
//            }
//            boolean menikoInput = test.inputTurn(t, x, y);
//            System.out.println("vuor: " + vuor + "| x: " + x + "| y: " + y);
//            System.out.println("meniko: " + menikoInput);
//            System.out.println("turn: " + test.getTurnNumber());
//            System.out.println();
//            System.out.println(test.toString());
//            System.out.println();
//
//        }
//
//        System.out.println();
//        System.out.println("Done!");
//        System.out.println("And the winner is: " + test.checkWinners().getName());
    }

}
