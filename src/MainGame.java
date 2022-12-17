import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;
public class MainGame {

    public static void main(String[] args) {

        // In order to create visual jumpscares, we can use the Java GUI class to create a frame that will display an image.
        //We create an import of the relevant Java classes, which include scanner, random, file and image.

        JFrame frame = new JFrame("You are trapped");

        //We create a new instance of the JFrame class in which we give the appropriate title.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //This line of code ensures that the frame will be exited once closed.
        frame.setSize(300, 300);
        //This code sets the size of the frame.
        JButton esc = new JButton("PRESS TO ESCAPE");
        //To add interactivity to the frame, a button is created, which will be used by the player to escape the trap.
        esc.addActionListener((event) -> System.exit(0));
        //This line of code allows the button to exit the frame.
        frame.getContentPane().add(esc);

        //To create a frame with the gif image  we generate another instance of JFrame.
        JFrame jumpScare = new JFrame();
        jumpScare.setTitle("BOOO");
        jumpScare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jumpScare.setLayout(null);
        jumpScare.setBounds(100, 200, 600, 600);
        //Here we set the specific location and size of the frame, to ensure that the image is shown correctly.
        Container jump = jumpScare.getContentPane();

        JLabel label = new JLabel();
        //We create a new label to place the image on, in which the container will be used to add the image to the frame.
        label.setIcon(new ImageIcon("unknown.gif"));
        Dimension size = label.getPreferredSize();
        //The code above will ensure that the label is of appropriate size.
        label.setBounds(50, 30, size.width, size.height);
        jump.add(label);
        //The container adds the label to the frame.
        JFrame jumpScare2 = new JFrame();
        jumpScare2.setTitle("HAHAHAHA");
        jumpScare2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jumpScare2.setLayout(null);
        jumpScare2.setBounds(100, 200, 600, 600);
        Container jump2 = jumpScare2.getContentPane();

        JLabel label2 = new JLabel();
        label2.setIcon(new ImageIcon("unnamed.gif"));
        Dimension size2 = label2.getPreferredSize();
        label2.setBounds(50, 30, size2.width, size2.height);
        jump2.add(label2);







        //For the main program we start of by importing the random and scanner class.

        Random rand = new Random();

        //The random class will be used to randomly place the player in the map when the game starts.

        Scanner control = new Scanner(System.in);

        //Here we create an instance of the class character and since the player is going to declare the name and health via input, the name is undefined and health is zero.

        Character c1 = new Character("Undefined", 0, false);
        System.out.println("Please create a name for your character:");
        System.out.println("");

        //We ask the player to provide a name for their character.

        String name = control.next();
        c1.setName(name);
        //The program also asks the user if they would like to have a protective armor, in which the armour variable will be modified according to their response.
        System.out.println("Would you like to have protective armour Y or N?");
        String armour = control.next();

        switch (armour) {
            case "Y":
                c1.setArmour(true);
                break;
        }

        //The difficulty is also decided by the player, in which the amount of health and the amount of tries the player gets is determined upon.

        System.out.println("Please select your difficulty");
        System.out.println(" ");
        System.out.println("Easy, Meduim, Hard, Hardcore");
        String dif = control.next();
        int turns = 0;
        int damage = 0;

        //In order to allow the difficulty to change the number of turns, amount of damage and health that the player starts of with, a switch case statement is used here.

        switch (dif) {
            case "Easy":
                c1.setHealth(1000);
                turns = turns + 15;
                damage = 100;
                break;
            case "Meduim":
                c1.setHealth(700);
                turns = turns + 10;
                damage = 200;
                break;
            case "Hard":
                c1.setHealth(500);
                turns = turns + 6;
                damage = 250;
                break;
            case "Hardcore":
                c1.setHealth(300);
                damage = 250;
                turns = turns + 5;
                break;

                //In order for the armour to do its job, if the user has armour set to true, then their health will double.
        }

        if (c1.getArmour() == true) {
            c1.setHealth(c1.getHealth() * 2);
        }

        System.out.println("Please select the size for the sandbox");
        System.out.println("X");
        int sizex = control.nextInt();
        System.out.println("Y");
        int sizey = control.nextInt();
        Map map1 = new Map(sizex, sizey);

        //When the game starts, the player will get a print statement stating their character name, health and number of turns they have to fulfil the objectives of the game. As well as explaining the context.

        //To make the game challenging, every time the program runs, the player will be placed on a random area in the map.

        map1.setCurrentx(rand.nextInt(sizex));
        map1.setCurrenty(rand.nextInt(sizey));
        //To make the game fair the number of turns is dependant on the size of the map
        if (sizex >= 100 || sizey >= 100) {
            turns = turns * 8;
        } else if (sizex >= 50 || sizey >= 50) {
            turns = turns * 4;
        } else if (sizex >= 30 || sizey >= 30) {
            turns = turns * 2;
        }
        // In order to randomise the location of special scenarios, a int array is created alongside a series of variables containing random numbers.
        int[] randloc = new int[sizex * sizey];

        int randnumber, randnumber2, randnumber3, randnumber4, randnumber5, randnumber6, randnumber7;
        randnumber = rand.nextInt(sizex * sizey);
        randnumber2 = rand.nextInt(sizex * sizey);
        randnumber3 = rand.nextInt(sizex * sizey);
        randnumber4 = rand.nextInt(sizex * sizey);
        randnumber5 = rand.nextInt(sizex * sizey);
        randnumber6 = rand.nextInt(sizex * sizey);
        randnumber7 = rand.nextInt(sizex * sizey);

        //The randnumbers are variables with random numbers that will be used as indexes to access the array randloc.

        //To generate an int array with random numbers, a for loop is used to add a random number to the array at every iteration.
        for (int b = 0; b < randloc.length; b++) {
            randloc[b] = rand.nextInt();
        }


        System.out.println("You are in London, a big and vibrant city, your objective is to find a hidden gem and bring it back in one piece to the lab, choose your moves wisly as your jetpack has a limited amount of fuel, in which you can only go to " + " " + turns + " " + "places");

        System.out.println("");

        System.out.println("Welcome to London" + " " + c1.getName());
        System.out.println("");
        System.out.println("Your location is at:" + " " + map1.getCurrentx() + " , " + map1.getCurrenty());

        //The for loop allows the player to move around the map and interact with the game, the loop stops when i gets to zero, i is equal to the amount of turns the player has. According to what input the player gives, the .move method will modify the currentx and currenty values accordingly.

        //Also if a player reaches a specific location in the game, special events will occur, which are also carried out through if statements in the loop.

        //If the player's health reaches zero or if the player's turns expire then the game will end.

        //At the end of each iteration, there will be a print statement detailing where the player is in the map as well as how many turns they have left.

        for (int i = turns; i > 0; i--) {
            System.out.println("Please choose your action \n N - NORTH ,S - SOUTH,E - EAST,W - WEST");
            System.out.println("--------------------------------------------------------------------");
            String position = control.next();
            if (position.equals("N") || position.equals("n")) {
                map1.move("N");
            } else if (position.equals("E") || position.equals("e")) {
                map1.move("E");
            } else if (position.equals("S") || position.equals("s")) {
                map1.move("S");
            } else if (position.equals("W") || position.equals("w")) {
                map1.move("W");
            }
            System.out.println("The character" + " " + c1.getName() + " has health of" + " " + c1.getHealth());
            System.out.println("The character " + c1.getName() + " is at " + map1.getCurrentx() + "," + map1.getCurrenty());
            //The series of if statements controls what happens when a player encounters a special event, to make the game more fun, I wanted to make it so that every time the program starts, the location is randomised for every scenario and to ensure that they each get different random numbers, each of the if statements will access a random index from the array randloc, which will change everytime the program runs.
            if (map1.getCurrentx() == randloc[randnumber] && map1.getCurrenty() == randloc[randnumber2]) {
                System.out.println("You have found a train that leads to the capital city");
                System.out.println("-----------------------------------------------------");
                System.out.println("Boarding train and heading to the city");
                map1.setCurrentx(5);
                map1.setCurrenty(10);
                System.out.println("You are at Oxford Circus Station, your coordinates are now: " + map1.getCurrentx() + " , " + map1.getCurrenty());
            }

            if (map1.getCurrentx() == randloc[randnumber3] && map1.getCurrenty() == randloc[randnumber4]) {
                System.out.println("You have just steped on a random teleporter");
                System.out.println("-------------------------------------------");
                System.out.println("T e l e p o r t i n g");
                map1.setCurrentx(rand.nextInt(sizex));
                map1.setCurrenty(rand.nextInt(sizey));
                System.out.println("Your coordinates are now: " + map1.getCurrentx() + " , " + map1.getCurrenty());
            }

            if (map1.getCurrentx() == randloc[randnumber4] && map1.getCurrenty() == randloc[randnumber5]) {
                c1.setHealth(c1.getHealth() - damage);
                System.out.println("You have encountered a hazard, health" + " - " + damage);
                System.out.println("Your health is now:" + " " + c1.getHealth());
            }

            if (map1.getCurrentx() == randloc[randnumber6] && map1.getCurrenty() == randloc[randnumber7]) {
                System.out.println("You have found the crystal gems, please go to the labortary at location: 6,9");
                System.out.println("-----------------------------------------------------------------------------");
                System.out.println("Look there is a bus that leads straight to the station next to the lab");
                map1.setCurrentx(6);
                map1.setCurrenty(9);
                System.out.println("You are now at the Lab, your coordinates are now: " + map1.getCurrentx() + " , " + map1.getCurrenty());
                System.out.println("You have completed the game with " + " " + i + " " + "tries");
                break;
            }

            if (map1.getCurrentx() == randloc[randnumber2] && map1.getCurrenty() == randloc[randnumber5]) {
                frame.setVisible(true);
                //If the expression is true, then the appropriate frame will popup.
            }

            if (map1.getCurrentx() == randloc[randnumber] && map1.getCurrenty() == randloc[randnumber6]) {
                jumpScare.setVisible(true);
            }

            if (map1.getCurrentx() == randloc[randnumber2] && map1.getCurrenty() == randloc[randnumber7] && dif.equals("Hard") || dif.equals("Hardcore")) {
                jumpScare2.setVisible(true);
                //Also for the hardcore players, there is an additional jumpscare feature.
            }

            if (c1.getHealth() == 0) {
                System.out.println("Your character has died, game over");
                break;
            }
            System.out.println("You have " + i + "" + " turns left");
        }



    }

}