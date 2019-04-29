import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Coursework_2 {
    static int level;
    static String numSkill;
    static String name;
    static String userSelectionCharacter;
    static int userSelectionMethod;
    static int stats0, stats1, stats2, stats3, stats4, stats5;
    static int[] strength = new int[6];
    static int strength0 = strength[0];
    static int strength1 = strength[1];
    static int strength2 = strength[2];
    static int strength3 = strength[3];
    static int strength4 = strength[4];
    static int strength5 = strength[5];
    static int tempStrength0;
    static int tempStrength1;
    static int tempStrength2;
    static int tempStrength3;
    static int tempStrength4;
    static int tempStrength5;
    static int finalStats0;
    static int finalStats1;
    static int finalStats2;
    static int finalStats3;
    static int finalStats4;
    static int finalStats5;
    static int finalBonus0;
    static int finalBonus1;
    static int finalBonus2;
    static int finalBonus3;
    static int finalBonus4;
    static int finalBonus5;
    static String[] selectedArr;
    static int BAB;
    static int combat;
    static int skillPoints;
    static int damage;
    static Scanner sc = new Scanner(System.in);
    static Character objCharacter = new Character();

    public static void main(String[] args) throws IOException {
        subMain();
    }

    // new sub main method created
    public static void subMain() {
        System.out.print("Enter a level: ");
        level = sc.nextInt();
        try {
            getInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getInput() throws IOException {
        boolean t = true;
        if (level < 1 || level > 20) {  //Condition to check whether the level meets the expected condition
            t = false;

        } else {
            getUserInput(); //if the condition is met getUserInput method is called
        }
        while (t == false) {
            System.out.println("Please enter a level between 1 to 20");  //if not met; message is prompt
            level = sc.nextInt();
            getInput();  //again get method is invoked so that the condition is checked again for the new level entered
            break;

        }

    }

    //contains the method to display the characters by reading
    private static void getUserInput() throws IOException {
        System.out.println("Level :" + level);
        Skills.character();
        getCharacter();
    }

    //for user to enter their favourite character name
    private static void getCharacter() throws IOException {
        System.out.print("Enter your favourite character name from the above list : ");
        userSelectionCharacter = sc.next().toLowerCase().trim();
        checkName();
        System.out.println(" ");
        methods();
    }

    //checks if the character name is properly entered
    private static void checkName() throws IOException {
        if (!(userSelectionCharacter.equals("barbarian") || userSelectionCharacter.equals("bard") || userSelectionCharacter.equals("cleric") ||
                userSelectionCharacter.equals("druid") || userSelectionCharacter.equals("fighter") || userSelectionCharacter.equals("monk") ||
                userSelectionCharacter.equals("paladin") || userSelectionCharacter.equals("ranger") || userSelectionCharacter.equals("rogue") ||
                userSelectionCharacter.equals("sorcerer") || userSelectionCharacter.equals("warlock") || userSelectionCharacter.equals("wizard"))) {
            System.out.print("Please enter the name properly : ");
            userSelectionCharacter = sc.next().toLowerCase().trim();
            checkName();
        }
    }

    //contains the four different methods to roll
    private static void methods() throws IOException {
        System.out.print("Please enter the number of the method to generate the stats:  \n");
        System.out.println("1. By manually entering the number");
        System.out.println("2. Roll 4d6 and discard the lowest value");
        System.out.println("3. Roll 4d6 and discard the lowest value and if the attribute is 16 or higher, add a value of an adiitional 1d6");
        System.out.println("4. Roll method IX");
        System.out.print("***Enter your choose : ");
        userSelectionMethod = sc.nextInt();
        System.out.println(" ");

        if (userSelectionMethod == 1) {
            userEnter();
            message();
        } else if (userSelectionMethod == 2) {
            discardLowest();
            message();
        } else if (userSelectionMethod == 3) {
            discardLowestWith16();
            message();
        } else if (userSelectionMethod == 4) {
            rollMethodNine();
            message();
        }
    }

    private static void userEnter() {
        System.out.print("Input value for STR : ");
        stats0 = sc.nextInt();
        finalStats0 = stats0;
        System.out.print("Input value for DEX : ");
        stats1 = sc.nextInt();
        finalStats1 = stats1;
        System.out.print("Input value for CON : ");
        stats2 = sc.nextInt();
        finalStats2 = stats2;
        System.out.print("Input value for INT : ");
        stats3 = sc.nextInt();
        finalStats3 = stats3;
        System.out.print("Input value for WIS : ");
        stats4 = sc.nextInt();
        finalStats4 = stats4;
        System.out.print("Input value for CHA : ");
        stats5 = sc.nextInt();
        finalStats5 = stats5;

        finalBonus0 = calculateBonus(stats0);
        finalBonus1 = calculateBonus(stats1);
        finalBonus2 = calculateBonus(stats2);
        finalBonus3 = calculateBonus(stats3);
        finalBonus4 = calculateBonus(stats4);
        finalBonus5 = calculateBonus(stats5);

        if (calculateBonus(stats0) > 0) {
            System.out.println("Str : [" + stats0 + "] [+" + calculateBonus(stats0) + "]");
        } else {
            System.out.println("Str : [" + stats0 + "] [" + calculateBonus(stats0) + "]");
        }

        if (calculateBonus(stats1) > 0) {
            System.out.println("Dex : [" + stats1 + "] [+" + calculateBonus(stats1) + "]");
        } else {
            System.out.println("Dex : [" + stats1 + "] [" + calculateBonus(stats1) + "]");
        }

        if (calculateBonus(stats2) > 0) {
            System.out.println("Con : [" + stats2 + "] [+" + calculateBonus(stats2) + "]");
        } else {
            System.out.println("Con : [" + stats2 + "] [" + calculateBonus(stats2) + "]");
        }

        if (calculateBonus(stats3) > 0) {
            System.out.println("Int : [" + stats3 + "] [+" + calculateBonus(stats3) + "]");
        } else {
            System.out.println("Int : [" + stats3 + "] [" + calculateBonus(stats3) + "]");
        }

        if (calculateBonus(stats4) > 0) {
            System.out.println("Wis : [" + stats4 + "] [+" + calculateBonus(stats4) + "]");
        } else {
            System.out.println("Wis : [" + stats4 + "] [" + calculateBonus(stats4) + "]");
        }

        if (calculateBonus(stats5) > 0) {
            System.out.println("Cha : [" + stats5 + "] [+" + calculateBonus(stats5) + "]");
        } else {
            System.out.println("Cha : [" + stats5 + "] [" + calculateBonus(stats5) + "]");
        }

        //hitpoints
        objCharacter.character(userSelectionCharacter);
        if (calculateBonus(stats2) < 0) {   //checks if conBonus is less than 0
            System.out.println("Hitpoints: " + (1 * level));
        } else {
            System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(stats2)));
        }
    }

    //method which gets 4random numbers and drops the lowest
    private static int calculatePower() {
        int[] tempArray = new int[4];
        for (int i = 0; i < 4; i++) {
            tempArray[i] = (int) (Math.random() * 1000 % 6 + 1);
        }

        Arrays.sort(tempArray);
        int totalPower = 0;
        for (int i = 1; i < tempArray.length; i++) {
            totalPower += tempArray[i];
        }
        return totalPower;
    }

    //values from calculatePower method is used
    private static int[] discardLowest() {
        for (int i = 0; i < strength.length; i++) {
            strength[i] = calculatePower();
        }

        finalStats0 = strength[0];
        finalStats1 = strength[1];
        finalStats2 = strength[2];
        finalStats3 = strength[3];
        finalStats4 = strength[4];
        finalStats5 = strength[5];

        finalBonus0 = calculateBonus(strength[0]);
        finalBonus1 = calculateBonus(strength[1]);
        finalBonus2 = calculateBonus(strength[2]);
        finalBonus3 = calculateBonus(strength[3]);
        finalBonus4 = calculateBonus(strength[4]);
        finalBonus5 = calculateBonus(strength[5]);

        if (calculateBonus(strength[0]) > 0) {
            System.out.println("Str : [" + strength[0] + "] [+" + calculateBonus(strength[0]) + "]");
        } else {
            System.out.println("Str : [" + strength[0] + "] [" + calculateBonus(strength[0]) + "]");
        }


        if (calculateBonus(strength[1]) > 0) {
            System.out.println("Dex : [" + strength[1] + "] [+" + calculateBonus(strength[1]) + "]");
        } else {
            System.out.println("Dex : [" + strength[1] + "] [" + calculateBonus(strength[1]) + "]");
        }

        if (calculateBonus(strength[2]) > 0) {
            System.out.println("Con : [" + strength[2] + "] [+" + calculateBonus(strength[2]) + "]");
        } else {
            System.out.println("Con : [" + strength[2] + "] [" + calculateBonus(strength[2]) + "]");
        }

        if (calculateBonus(strength[3]) > 0) {
            System.out.println("Int : [" + strength[3] + "] [+" + calculateBonus(strength[3]) + "]");
        } else {
            System.out.println("Int : [" + strength[3] + "] [" + calculateBonus(strength[3]) + "]");
        }

        if (calculateBonus(strength[4]) > 0) {
            System.out.println("Wis : [" + strength[4] + "] [+" + calculateBonus(strength[4]) + "]");
        } else {
            System.out.println("Wis : [" + strength[4] + "] [" + calculateBonus(strength[4]) + "]");
        }

        if (calculateBonus(strength[5]) > 0) {
            System.out.println("Cha : [" + strength[5] + "] [+" + calculateBonus(strength[5]) + "]");

        } else {
            System.out.println("Cha : [" + strength[5] + "] [" + calculateBonus(strength[5]) + "]");
        }

        //hitpoints
        objCharacter.character(userSelectionCharacter);
        if (calculateBonus(strength[2]) < 0) {
            System.out.println("Hitpoints: " + (1 * level));
        } else {
            System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(strength[2])));
        }
        return strength;
    }

    //values from calculatePower method is used
    private static void discardLowestWith16() {
        for (int i = 0; i < strength.length; i++) {
            strength[i] = calculatePower();
        }

        finalStats0 = strength[0];
        finalStats1 = strength[1];
        finalStats2 = strength[2];
        finalStats3 = strength[3];
        finalStats4 = strength[4];
        finalStats5 = strength[5];

        finalBonus0 = calculateBonus(strength[0]);
        finalBonus1 = calculateBonus(strength[1]);
        finalBonus2 = calculateBonus(strength[2]);
        finalBonus3 = calculateBonus(strength[3]);
        finalBonus4 = calculateBonus(strength[4]);
        finalBonus5 = calculateBonus(strength[5]);

        //checks if the value from the calculatePower method is 16 or greater if greater 1d6 is added
        if (calculateBonus(strength[0]) > 0) {
            if (strength[0] >= 16) {
                tempStrength0 = (int) ((strength[0]) + (Math.random() * 1000 % 6 + 1));
                System.out.println("Dex : [" + tempStrength0 + "][+" + calculateBonus(tempStrength0) + "]");
            } else {
                System.out.println("Dex : [" + strength[0] + "][+" + calculateBonus(strength[0]) + "]");
            }
        } else {
            System.out.println("Dex : [" + strength[0] + "][" + calculateBonus(strength[0]) + "]");
        }


        if (calculateBonus(strength[1]) > 0) {
            if (strength[1] >= 16) {
                tempStrength1 = (int) ((strength[1]) + (Math.random() * 1000 % 6 + 1));
                System.out.println("Dex : [" + tempStrength1 + "][+" + calculateBonus(tempStrength1) + "]");
            } else {
                System.out.println("Dex : [" + strength[1] + "][+" + calculateBonus(strength[1]) + "]");
            }
        } else {
            System.out.println("Dex : [" + strength[1] + "][" + calculateBonus(strength[1]) + "]");
        }


        if (calculateBonus(strength[2]) > 0) {
            if (strength[2] >= 16) {
                tempStrength2 = (int) ((strength[2]) + (Math.random() * 1000 % 6 + 1));
                System.out.println("Con : [" + tempStrength2 + "][+" + calculateBonus(tempStrength2) + "]");
            } else {
                System.out.println("Con : [" + strength[2] + "][+" + calculateBonus(strength[2]) + "]");
            }
        } else {
            System.out.println("Con : [" + strength[2] + "][" + calculateBonus(strength[2]) + "]");
        }


        if (calculateBonus(strength[3]) > 0) {
            tempStrength3 = (int) ((strength[3]) + (Math.random() * 1000 % 6 + 1));
            if (strength[3] >= 16) {
                System.out.println("Int : [" + tempStrength3 + "][+" + calculateBonus(tempStrength3) + "]");
            } else {
                System.out.println("Int : [" + strength[3] + "][+" + calculateBonus(strength[3]) + "]");
            }
        } else {
            System.out.println("Int : [" + strength[3] + "][" + calculateBonus(strength[3]) + "]");
        }


        if (calculateBonus(strength[4]) > 0) {
            if (strength[4] >= 16) {
                tempStrength4 = (int) ((strength[4]) + (Math.random() * 1000 % 6 + 1));
                System.out.println("Wis : [" + tempStrength4 + "][+" + calculateBonus(tempStrength4) + "]");
            } else {
                System.out.println("Wis : [" + strength[4] + "][+" + calculateBonus(strength[4]) + "]");
            }
        } else {
            System.out.println("Wis : [" + strength[4] + "][" + calculateBonus(strength[4]) + "]");
        }


        if (calculateBonus(strength[5]) > 0) {
            tempStrength5 = (int) ((strength[5]) + (Math.random() * 1000 % 6 + 1));
            if (strength[5] >= 16) {
                System.out.println("Cha : [" + tempStrength5 + "][+" + calculateBonus(tempStrength5) + "]");
            } else {
                System.out.println("Cha : [" + strength[5] + "][+" + calculateBonus(strength[5]) + "]");
            }
        } else {
            System.out.println("Cha : [" + strength[5] + "][" + calculateBonus(strength[5]) + "]");
        }

        //hitpoints
        objCharacter.character(userSelectionCharacter);
        if (strength[2] >= 16) {
            if (calculateBonus(tempStrength2) < 0) {
                System.out.println("Hitpoints: " + (1 * level));
            } else {
                System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(tempStrength2)));
            }
        } else {
            if (calculateBonus(strength[2]) < 0) {
                System.out.println("Hitpoints: " + (1 * level));
            } else {
                System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(strength[2])));
            }
        }
    }

    //Roll method IX
    private static void rollMethodNine() {
        //generates 9 random numbers and picks the highest three numbers
        int[] tempArray0 = new int[9];
        for (int i = 0; i < tempArray0.length; i++) {
            tempArray0[i] = (int) (Math.random() * 1000 % 6 + 1);
        }
        Arrays.sort(tempArray0);
        strength[0] = tempArray0[8] + tempArray0[7] + tempArray0[6];

        //generates 8 random numbers and picks the highest three numbers
        int[] tempArray1 = new int[8];
        for (int i = 0; i < tempArray1.length; i++) {
            tempArray1[i] = (int) (Math.random() * 1000 % 6 + 1);
        }
        Arrays.sort(tempArray1);
        strength[1] = tempArray1[7] + tempArray1[6] + tempArray1[5];

        //generates 7 random numbers and picks the highest three numbers
        int[] tempArray2 = new int[7];
        for (int i = 0; i < tempArray2.length; i++) {
            tempArray2[i] = (int) (Math.random() * 1000 % 6 + 1);
        }
        Arrays.sort(tempArray0);
        strength[2] = tempArray2[6] + tempArray2[5] + tempArray2[4];

        //generates 6 random numbers and picks the highest three numbers
        int[] tempArray3 = new int[6];
        for (int i = 0; i < tempArray3.length; i++) {
            tempArray3[i] = (int) (Math.random() * 1000 % 6 + 1);
        }
        Arrays.sort(tempArray0);
        strength[3] = tempArray3[5] + tempArray3[4] + tempArray3[3];

        //generates 5 random numbers and picks the highest three numbers
        int[] tempArray4 = new int[5];
        for (int i = 0; i < tempArray4.length; i++) {
            tempArray4[i] = (int) (Math.random() * 1000 % 6 + 1);
        }
        Arrays.sort(tempArray0);
        strength[4] = tempArray0[4] + tempArray0[3] + tempArray0[2];

        //generates 4 random numbers and picks the highest three numbers
        int[] tempArray5 = new int[4];
        for (int i = 0; i < tempArray5.length; i++) {
            tempArray5[i] = (int) (Math.random() * 1000 % 6 + 1);
        }
        Arrays.sort(tempArray0);
        strength[5] = tempArray0[3] + tempArray0[2] + tempArray0[1];

        finalStats0 = strength[0];
        finalStats1 = strength[1];
        finalStats2 = strength[2];
        finalStats3 = strength[3];
        finalStats4 = strength[4];
        finalStats5 = strength[5];

        finalBonus0 = calculateBonus(strength[0]);
        finalBonus1 = calculateBonus(strength[1]);
        finalBonus2 = calculateBonus(strength[2]);
        finalBonus3 = calculateBonus(strength[3]);
        finalBonus4 = calculateBonus(strength[4]);
        finalBonus5 = calculateBonus(strength[5]);

        if (userSelectionCharacter.equals("barbarian") || userSelectionCharacter.equals("fighter") || userSelectionCharacter.equals("paladin")) {
            if (calculateBonus(strength[0]) > 0) {
                System.out.println("Str : [" + strength[0] + "] [+" + calculateBonus(strength[0]) + "]");
            } else {
                System.out.println("Str : [" + strength[0] + "] [" + calculateBonus(strength[0]) + "]");
            }


            if (calculateBonus(strength[1]) > 0) {
                System.out.println("Dex : [" + strength[1] + "] [+" + calculateBonus(strength[1]) + "]");
            } else {
                System.out.println("Dex : [" + strength[1] + "] [" + calculateBonus(strength[1]) + "]");
            }

            if (calculateBonus(strength[2]) > 0) {
                System.out.println("Con : [" + strength[2] + "] [+" + calculateBonus(strength[2]) + "]");
            } else {
                System.out.println("Con : [" + strength[2] + "] [" + calculateBonus(strength[2]) + "]");
            }

            if (calculateBonus(strength[3]) > 0) {
                System.out.println("Int : [" + strength[3] + "] [+" + calculateBonus(strength[3]) + "]");
            } else {
                System.out.println("Int : [" + strength[3] + "] [" + calculateBonus(strength[3]) + "]");
            }

            if (calculateBonus(strength[4]) > 0) {
                System.out.println("Wis : [" + strength[4] + "] [+" + calculateBonus(strength[4]) + "]");
            } else {
                System.out.println("Wis : [" + strength[4] + "] [" + calculateBonus(strength[4]) + "]");
            }

            if (calculateBonus(strength[5]) > 0) {
                System.out.println("Cha : [" + strength[5] + "] [+" + calculateBonus(strength[5]) + "]");

            } else {
                System.out.println("Cha : [" + strength[5] + "] [" + calculateBonus(strength[5]) + "]");
            }

            //hitpoints for barbarian, fighter and paladin
            objCharacter.character(userSelectionCharacter);
            if (calculateBonus(strength[2]) < 0) {
                System.out.println("Hitpoints: " + (1 * level));
            } else {
                System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(strength[2])));
            }
        } else if (userSelectionCharacter.equals("bard") || userSelectionCharacter.equals("sorcerer") || userSelectionCharacter.equals("warlock")) {
            if (calculateBonus(strength[0]) > 0) {
                System.out.println("Cha : [" + strength[0] + "] [+" + calculateBonus(strength[0]) + "]");
            } else {
                System.out.println("Cha : [" + strength[0] + "] [" + calculateBonus(strength[0]) + "]");
            }


            if (calculateBonus(strength[1]) > 0) {
                System.out.println("Str : [" + strength[1] + "] [+" + calculateBonus(strength[1]) + "]");
            } else {
                System.out.println("Str : [" + strength[1] + "] [" + calculateBonus(strength[1]) + "]");
            }

            if (calculateBonus(strength[2]) > 0) {
                System.out.println("Wis : [" + strength[2] + "] [+" + calculateBonus(strength[2]) + "]");
            } else {
                System.out.println("Wis : [" + strength[2] + "] [" + calculateBonus(strength[2]) + "]");
            }

            if (calculateBonus(strength[3]) > 0) {
                System.out.println("Dex : [" + strength[3] + "] [+" + calculateBonus(strength[3]) + "]");
            } else {
                System.out.println("Dex : [" + strength[3] + "] [" + calculateBonus(strength[3]) + "]");
            }

            if (calculateBonus(strength[4]) > 0) {
                System.out.println("Con : [" + strength[4] + "] [+" + calculateBonus(strength[4]) + "]");
            } else {
                System.out.println("Con : [" + strength[4] + "] [" + calculateBonus(strength[4]) + "]");
            }

            if (calculateBonus(strength[5]) > 0) {
                System.out.println("Int : [" + strength[5] + "] [+" + calculateBonus(strength[5]) + "]");
            } else {
                System.out.println("Int : [" + strength[5] + "] [" + calculateBonus(strength[5]) + "]");
            }

            //hitpoints for bard, sorcerer and warlock
            objCharacter.character(userSelectionCharacter);
            if (calculateBonus(strength[4]) < 0) {
                System.out.println("Hitpoints: " + (1 * level));
            } else {
                System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(strength[4])));
            }
        } else if (userSelectionCharacter.equals("cleric") || userSelectionCharacter.equals("druid")) {
            if (calculateBonus(strength[0]) > 0) {
                System.out.println("Wis : [" + strength[0] + "] [+" + calculateBonus(strength[0]) + "]");
            } else {
                System.out.println("Wis : [" + strength[0] + "] [" + calculateBonus(strength[0]) + "]");
            }


            if (calculateBonus(strength[1]) > 0) {
                System.out.println("Int : [" + strength[1] + "] [+" + calculateBonus(strength[1]) + "]");
            } else {
                System.out.println("Int : [" + strength[1] + "] [" + calculateBonus(strength[1]) + "]");
            }

            if (calculateBonus(strength[2]) > 0) {
                System.out.println("Cha : [" + strength[2] + "] [+" + calculateBonus(strength[2]) + "]");
            } else {
                System.out.println("Cha : [" + strength[2] + "] [" + calculateBonus(strength[2]) + "]");
            }

            if (calculateBonus(strength[3]) > 0) {
                System.out.println("Con : [" + strength[3] + "] [+" + calculateBonus(strength[3]) + "]");
            } else {
                System.out.println("Con : [" + strength[3] + "] [" + calculateBonus(strength[3]) + "]");
            }

            if (calculateBonus(strength[4]) > 0) {
                System.out.println("Str : [" + strength[4] + "] [+" + calculateBonus(strength[4]) + "]");
            } else {
                System.out.println("Str : [" + strength[4] + "] [" + calculateBonus(strength[4]) + "]");
            }

            if (calculateBonus(strength[5]) > 0) {
                System.out.println("Dex : [" + strength[5] + "] [+" + calculateBonus(strength[5]) + "]");

            } else {
                System.out.println("Dex : [" + strength[5] + "] [" + calculateBonus(strength[5]) + "]");
            }

            //hitpoints for cleric and druid
            objCharacter.character(userSelectionCharacter);
            if (calculateBonus(strength[3]) < 0) {
                System.out.println("Hitpoints: " + (1 * level));
            } else {
                System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(strength[3])));
            }
        } else if (userSelectionCharacter.equals("monk") || userSelectionCharacter.equals("ranger") || userSelectionCharacter.equals("rogue")) {
            if (calculateBonus(strength[0]) > 0) {
                System.out.println("Dex : [" + strength[0] + "] [+" + calculateBonus(strength[0]) + "]");
            } else {
                System.out.println("Dex : [" + strength[0] + "] [" + calculateBonus(strength[0]) + "]");
            }


            if (calculateBonus(strength[1]) > 0) {
                System.out.println("Con : [" + strength[1] + "] [+" + calculateBonus(strength[1]) + "]");
            } else {
                System.out.println("Con : [" + strength[1] + "] [" + calculateBonus(strength[1]) + "]");
            }

            if (calculateBonus(strength[2]) > 0) {
                System.out.println("Wis : [" + strength[2] + "] [+" + calculateBonus(strength[2]) + "]");
            } else {
                System.out.println("Wis : [" + strength[2] + "] [" + calculateBonus(strength[2]) + "]");
            }

            if (calculateBonus(strength[3]) > 0) {
                System.out.println("Cha : [" + strength[3] + "] [+" + calculateBonus(strength[3]) + "]");
            } else {
                System.out.println("Cha : [" + strength[3] + "] [" + calculateBonus(strength[3]) + "]");
            }

            if (calculateBonus(strength[4]) > 0) {
                System.out.println("Int : [" + strength[4] + "] [+" + calculateBonus(strength[4]) + "]");
            } else {
                System.out.println("Int : [" + strength[4] + "] [" + calculateBonus(strength[4]) + "]");
            }

            if (calculateBonus(strength[5]) > 0) {
                System.out.println("Str : [" + strength[5] + "] [+" + calculateBonus(strength[5]) + "]");

            } else {
                System.out.println("Str : [" + strength[5] + "] [" + calculateBonus(strength[5]) + "]");
            }

            //hitpoints for monk, ranger and rogue
            objCharacter.character(userSelectionCharacter);
            if (calculateBonus(strength[1]) < 0) {
                System.out.println("Hitpoints: " + (1 * level));
            } else {
                System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(strength[1])));
            }
        } else if (userSelectionCharacter.equals("wizard")) {
            if (calculateBonus(strength[0]) > 0) {
                System.out.println("Int : [" + strength[0] + "] [+" + calculateBonus(strength[0]) + "]");
            } else {
                System.out.println("Int : [" + strength[0] + "] [" + calculateBonus(strength[0]) + "]");
            }


            if (calculateBonus(strength[1]) > 0) {
                System.out.println("Cha : [" + strength[1] + "] [+" + calculateBonus(strength[1]) + "]");
            } else {
                System.out.println("Cha : [" + strength[1] + "] [" + calculateBonus(strength[1]) + "]");
            }

            if (calculateBonus(strength[2]) > 0) {
                System.out.println("Dex : [" + strength[2] + "] [+" + calculateBonus(strength[2]) + "]");
            } else {
                System.out.println("Dex : [" + strength[2] + "] [" + calculateBonus(strength[2]) + "]");
            }

            if (calculateBonus(strength[3]) > 0) {
                System.out.println("Str : [" + strength[3] + "] [+" + calculateBonus(strength[3]) + "]");
            } else {
                System.out.println("Str : [" + strength[3] + "] [" + calculateBonus(strength[3]) + "]");
            }

            if (calculateBonus(strength[4]) > 0) {
                System.out.println("Wis : [" + strength[4] + "] [+" + calculateBonus(strength[4]) + "]");
            } else {
                System.out.println("Wis : [" + strength[4] + "] [" + calculateBonus(strength[4]) + "]");
            }

            if (calculateBonus(strength[5]) > 0) {
                System.out.println("Con : [" + strength[5] + "] [+" + calculateBonus(strength[5]) + "]");

            } else {
                System.out.println("Con : [" + strength[5] + "] [" + calculateBonus(strength[5]) + "]");
            }

            //hitpoints for wizard
            objCharacter.character(userSelectionCharacter);
            if (calculateBonus(strength[5]) < 0) {
                System.out.println("Hitpoints: " + (1 * level));
            } else {
                System.out.println(" Hitpoints: " + (objCharacter.randomNumber + calculateBonus(strength[5])));
            }
        }

    }

    //method to calculate bonus
    private static int calculateBonus(int x) {
        int bonus;
        bonus = (x / 2) - 5;
        return bonus;
    }


    //skills are read through file reading
    private static void skills() throws IOException {
        System.out.println("Skills are displayed below, you have the opportunity to choose them: ");
        Skills.skills();
        int character = getCharacter(numSkill, level);
        int skill = sc.nextInt();
    }

    //the method which has allows the user to accept or reroll the stats
    public static void message() throws IOException {
        System.out.println("\nEnter 'YES' if happy OR 'ROll' to reroll");
        String exit = sc.next();
        if (exit.equalsIgnoreCase("YES")) {
            try {
                skills();
            } catch (IOException e) {
                e.printStackTrace();
            } //Invoking the calculation method as user is ready to calculate
        } else if (exit.equalsIgnoreCase("ROLL")) {
            if (userSelectionMethod == 1) {
                userEnter();
                message();
            } else if (userSelectionMethod == 2) {
                discardLowest();
                message();
            } else if (userSelectionMethod == 3) {
                discardLowestWith16();
                message();
            } else if (userSelectionMethod == 4) {
                rollMethodNine();
                message();
            }
        }
        System.exit(0);
    }

    //this method is to display a message to make the user a where of the skills that can be selected
    private static int getCharacter(String numSkill, int level) throws IOException {
        switch (level) {
            case 1:
                numSkill = "Choose any 1 skill from the above list: ";
                break;
            case 2:
                numSkill = "Choose any 2 skill from the above list: ";
                break;
            case 3:
                numSkill = "Choose any 3 skill from the above list: ";
                break;
            case 4:
                numSkill = "Choose any 4 skill from the above list: ";
                break;
            case 5:
                numSkill = "Choose any 5 skill from the above list: ";
                break;
            case 6:
                numSkill = "Choose any 6 skill from the above list: ";
                break;
            case 7:
                numSkill = "Choose any 7 skill from the above list: ";
                break;
            case 8:
                numSkill = "Choose any 8 skill from the above list: ";
                break;
            case 9:
                numSkill = "Choose any 9 skill from the above list: ";
                break;
            case 10:
                numSkill = "Choose any 10 skill from the above list: ";
                break;
            case 11:
                numSkill = "Choose any 11 skill from the above list: ";
                break;
            case 12:
                numSkill = "Choose any 12 skill from the above list: ";
                break;
            case 13:
                numSkill = "Choose any 13 skill from the above list: ";
                break;
            case 14:
                numSkill = "Choose any 14 skill from the above list: ";
                break;
            case 15:
                numSkill = "Choose any 15 skill from the above list: ";
                break;
            case 16:
                numSkill = "Choose any 16 skill from the above list: ";
                break;
            case 17:
                numSkill = "Choose any 17 skill from the above list: ";
                break;
            case 18:
                numSkill = "Choose any 18 skill from the above list: ";
                break;
            case 19:
                numSkill = "Choose any 18 skill from the above list: ";
                break;
            case 20:
                numSkill = "Choose any 18 skill from the above list: ";
                break;
            default:
                System.out.println("Invalid");
                System.exit(0);
                break;
        }
        System.out.println(numSkill);

        int num = 1;
        selectedArr = new String[level];
        for (int i = 0; i < level; i++) {
            System.out.print("Enter " + (num++) + " skill: ");  //a counter to show the number of skills to be yet to be entered
            int temp = sc.nextInt();

            switch (temp) {
                case 1:
                    selectedArr[i] = "1.Acrobatics       - Can play out an aerobatic stunt, maintain balance while strolling on thin or flimsy surfaces, slip free of limitations, or take less harm when fall.";
                    break;
                case 2:
                    selectedArr[i] = "2.Arcana           - It can be used to assemble information on mysterious related themes.";
                    break;
                case 3:
                    selectedArr[i] = "3.Athletics        - An Athletics attempt to physical activities that is based on muscular strength.";
                    break;
                case 4:
                    selectedArr[i] = "4.Bluff            - It check to fast-talk a security, con a merchant, gamble, pass off a disguise or lie documents, and generally tells lies.";
                    break;
                case 5:
                    selectedArr[i] = "5.Diplomacy        - It is used to switch opinions, to stimulate good will,or to bargain a deal in good faith and etc..";
                    break;
                case 6:
                    selectedArr[i] = "6.Dungeoneering    - Used to gather knowledge about an underground territory or to identify an underground threat or idea.";
                    break;
                case 7:
                    selectedArr[i] = "7.Endurance        - Checks to splinter off ill effects and to impel our-self beyond ordinary physical boundaries.";
                    break;
                case 8:
                    selectedArr[i] = "8.Heal             - Assists how to help someone improve from bruise or bad conditions, including disease.";
                    break;
                case 9:
                    selectedArr[i] = "9.History          - Includes the chronological record of important events and an explanation of those causes.";
                    break;
                case 10:
                    selectedArr[i] = "10.Insight         - Inspects to understand the purpose, to find some hidden meaning, to get a feeling of moods and to decide how honest somebody is being.";
                    break;
                case 11:
                    selectedArr[i] = "11.Intimidate      - Makes an Intimidate survey to influence others through hostile actions, over threats, and deadly temptation. ";
                    break;
                case 12:
                    selectedArr[i] = "12.Nature          - Finding the way through the wild, identifying natural dangers, managing and recognizing regular animals, and living out of the land.";
                    break;
                case 13:
                    selectedArr[i] = "13.Perception      - Checks to notice ideas, detect hidden path ways , spot near dangers, find traps, follow tracks, listen for sounds behind a closed door, or find secret objects.";
                    break;
                case 14:
                    selectedArr[i] = "14.Religion        - Used to gather information about religion or to recognize a religion-related ideas.";
                    break;
                case 15:
                    selectedArr[i] = "15.Stealth         - Investigates to conceal from enemies, slip past guards, and move away without being noticed.";
                    break;
                case 16:
                    selectedArr[i] = "16.Streetwise      - Examines to find out what’s happening, who the movers and shakers are, where to get what you need,  and where access is not granted.";
                    break;
                case 17:
                    selectedArr[i] = "17.Thievery        - Can perform activities that needs nerves of steel and a steady hand.";
                    break;
                case 18:
                    selectedArr[i] = "18.Animal Handling - Checks to control the scale when a riskfull exercises are done.";
                    break;
            }
        }
        player();
        return num;
    }

    //printStats to print the stats relevant to the method and character
    private static void printStats() {
        if (userSelectionMethod == 1 || userSelectionMethod == 2 || userSelectionMethod == 3) {
            System.out.println("STR : [" + finalStats0 + "] [" + finalBonus0 + "]");
            System.out.println("DEX : [" + finalStats1 + "] [" + finalBonus1 + "]");
            System.out.println("CON : [" + finalStats2 + "] [" + finalBonus2 + "]");
            System.out.println("INT : [" + finalStats3 + "] [" + finalBonus3 + "]");
            System.out.println("WIS : [" + finalStats4 + "] [" + finalBonus4 + "]");
            System.out.println("CHA : [" + finalStats5 + "] [" + finalBonus5 + "]");
        } else if (userSelectionMethod == 4) {
            if (userSelectionCharacter.equals("barbarian") || userSelectionCharacter.equals("fighter") || userSelectionCharacter.equals("paladin")) {
                System.out.println("STR : [" + finalStats0 + "] [" + finalBonus0 + "]");
                System.out.println("DEX : [" + finalStats1 + "] [" + finalBonus1 + "]");
                System.out.println("CON : [" + finalStats2 + "] [" + finalBonus2 + "]");
                System.out.println("INT : [" + finalStats3 + "] [" + finalBonus3 + "]");
                System.out.println("WIS : [" + finalStats4 + "] [" + finalBonus4 + "]");
                System.out.println("CHA : [" + finalStats5 + "] [" + finalBonus5 + "]");
            } else if (userSelectionCharacter.equals("bard") || userSelectionCharacter.equals("sorcerer") || userSelectionCharacter.equals("warlock")) {
                System.out.println("CHA : [" + finalStats0 + "] [" + finalBonus0 + "]");
                System.out.println("STR : [" + finalStats1 + "] [" + finalBonus1 + "]");
                System.out.println("WIS : [" + finalStats2 + "] [" + finalBonus2 + "]");
                System.out.println("DEX : [" + finalStats3 + "] [" + finalBonus3 + "]");
                System.out.println("CON : [" + finalStats4 + "] [" + finalBonus4 + "]");
                System.out.println("INT : [" + finalStats5 + "] [" + finalBonus5 + "]");
            } else if (userSelectionCharacter.equals("cleric") || userSelectionCharacter.equals("druid")) {
                System.out.println("WIS : [" + finalStats0 + "] [" + finalBonus0 + "]");
                System.out.println("INT : [" + finalStats1 + "] [" + finalBonus1 + "]");
                System.out.println("CHA : [" + finalStats2 + "] [" + finalBonus2 + "]");
                System.out.println("CON : [" + finalStats3 + "] [" + finalBonus3 + "]");
                System.out.println("STR : [" + finalStats4 + "] [" + finalBonus4 + "]");
                System.out.println("DEX : [" + finalStats5 + "] [" + finalBonus5 + "]");
            } else if (userSelectionCharacter.equals("monk") || userSelectionCharacter.equals("ranger") || userSelectionCharacter.equals("rogue")) {
                System.out.println("DEX : [" + finalStats0 + "] [" + finalBonus0 + "]");
                System.out.println("CON : [" + finalStats1 + "] [" + finalBonus1 + "]");
                System.out.println("WIS : [" + finalStats2 + "] [" + finalBonus2 + "]");
                System.out.println("CHA : [" + finalStats3 + "] [" + finalBonus3 + "]");
                System.out.println("INT : [" + finalStats4 + "] [" + finalBonus4 + "]");
                System.out.println("STR : [" + finalStats5 + "] [" + finalBonus5 + "]");
            } else if (userSelectionCharacter.equals("wizard")) {
                System.out.println("INT : [" + finalStats0 + "] [" + finalBonus0 + "]");
                System.out.println("CHA : [" + finalStats1 + "] [" + finalBonus1 + "]");
                System.out.println("DEX : [" + finalStats2 + "] [" + finalBonus2 + "]");
                System.out.println("STR : [" + finalStats3 + "] [" + finalBonus3 + "]");
                System.out.println("WIS : [" + finalStats4 + "] [" + finalBonus4 + "]");
                System.out.println("CON : [" + finalStats5 + "] [" + finalBonus5 + "]");
            }
        }

    }

    //contains summary and from to save and continue play or quite
    private static int player() {
        System.out.println(" ");
        System.out.print("Enter players name: ");
        name = sc.next();
        System.out.println(" ");
        System.out.println("******************************");
        System.out.println("Name            : [" + name + "]");
        System.out.println("Level           : [" + level + "]");
        System.out.println("Character Class : [" + userSelectionCharacter + "]");
        System.out.println("------------------------------");
        printStats();
        System.out.println("------------------------------");
        System.out.println("Rank : " + (3 + level));
        Attack();
        System.out.println(" ");
        System.out.println("Do you want to save the stats ? [Type 'save' in order to save in a text file]");
        String save = sc.next().toLowerCase().trim();
        if (save.equals("save")) {
            writing();
        }
        System.out.println(" ");
        System.out.println("Do you want to Play again [yes/no] no will exit you from the game : ");
        String userInput = sc.next().toLowerCase().trim();
        if (userInput.equals("yes")) {
            subMain();
        } else {
            System.exit(1);
        }
        return level;
    }

    //contains BAB, Combat and Damage calculation
    private static void Attack() {
        if (userSelectionMethod == 1) {
            if ((userSelectionCharacter.equals("barbarian")) || (userSelectionCharacter.equals("druid")) ||
                    (userSelectionCharacter.equals("paladin")) || (userSelectionCharacter.equals("sorcerer"))) {

                BAB = level;
                combat = ((BAB) + (calculateBonus(stats0)));
                damage = calculateBonus(stats0);
                System.out.println("#BAB            : [" + BAB + "]");
                System.out.println("#Combat         : [" + combat + "]");
                System.out.println("#Damage         : [" + damage + "]");
                skillPoints();

            } else if ((userSelectionCharacter.equals("bard")) || (userSelectionCharacter.equals("fighter")) ||
                    (userSelectionCharacter.equals("ranger")) || (userSelectionCharacter.equals("warlock"))) {

                BAB = (level * 3) / 4;
                combat = ((BAB) + (calculateBonus(stats0)));
                damage = calculateBonus(stats0);
                System.out.println("#BAB            : [" + BAB + "]");
                System.out.println("#Combat         : [" + combat + "]");
                System.out.println("#Damage         : [" + damage + "]");
                skillPoints();

            } else if ((userSelectionCharacter.equals("cleric")) || (userSelectionCharacter.equals("monk")) ||
                    (userSelectionCharacter.equals("rogue")) || (userSelectionCharacter.equals("wizard"))) {

                BAB = level / 2;
                combat = ((BAB) + (calculateBonus(stats0)));
                damage = calculateBonus(stats0);
                System.out.println("#BAB            : [" + BAB + "]");
                System.out.println("#Combat         : [" + combat + "]");
                System.out.println("#Damage         : [" + damage + "]");
                skillPoints();
            }
        } else if (userSelectionMethod == 2 || userSelectionMethod == 4) {
            if ((userSelectionCharacter.equals("barbarian")) || (userSelectionCharacter.equals("druid")) ||
                    (userSelectionCharacter.equals("paladin")) || (userSelectionCharacter.equals("sorcerer"))) {

                BAB = level;
                combat = ((BAB) + calculateBonus(strength[0]));
                damage = calculateBonus(strength[0]);
                System.out.println("#BAB            : [" + BAB + "]");
                System.out.println("#Combat         : [" + combat + "]");
                System.out.println("#Damage         : [" + damage + "]");
                skillPoints();

            } else if ((userSelectionCharacter.equals("bard")) || (userSelectionCharacter.equals("fighter")) ||
                    (userSelectionCharacter.equals("ranger")) || (userSelectionCharacter.equals("warlock"))) {

                BAB = (level * 3) / 4;
                combat = ((BAB) + calculateBonus(strength[0]));
                damage = calculateBonus(strength[0]);
                System.out.println("#BAB            : [" + BAB + "]");
                System.out.println("#Combat         : [" + combat + "]");
                System.out.println("#Damage         : [" + damage + "]");
                skillPoints();

            } else if ((userSelectionCharacter.equals("cleric")) || (userSelectionCharacter.equals("monk")) ||
                    (userSelectionCharacter.equals("rogue")) || (userSelectionCharacter.equals("wizard"))) {

                BAB = level / 2;
                combat = ((BAB) + calculateBonus(strength[0]));
                damage = calculateBonus(strength[0]);
                System.out.println("#BAB            : [" + BAB + "]");
                System.out.println("#Combat         : [" + combat + "]");
                System.out.println("#Damage         : [" + damage + "]");
                skillPoints();
            }
        } else if (userSelectionMethod == 3) {
            if ((userSelectionCharacter.equals("barbarian")) || (userSelectionCharacter.equals("druid")) ||
                    (userSelectionCharacter.equals("paladin")) || (userSelectionCharacter.equals("sorcerer"))) {

                if (strength[0] >= 16) {
                    BAB = level;
                    combat = ((BAB) + calculateBonus(tempStrength0));
                    damage = calculateBonus(tempStrength0);
                    System.out.println("#BAB            : [" + BAB + "]");
                    System.out.println("#Combat         : [" + combat + "]");
                    System.out.println("#Damage         : [" + damage + "]");
                    skillPoints();
                } else {
                    BAB = level;
                    combat = ((BAB) + calculateBonus(strength[0]));
                    damage = calculateBonus(strength[0]);
                    System.out.println("#BAB            : [" + BAB + "]");
                    System.out.println("#Combat         : [" + combat + "]");
                    System.out.println("#Damage         : [" + damage + "]");
                    skillPoints();
                }


            } else if ((userSelectionCharacter.equals("bard")) || (userSelectionCharacter.equals("fighter")) ||
                    (userSelectionCharacter.equals("ranger")) || (userSelectionCharacter.equals("warlock"))) {

                if (strength[0] >= 16) {
                    BAB = (level * 3) / 4;
                    combat = ((BAB) + calculateBonus(tempStrength0));
                    damage = calculateBonus(tempStrength0);
                    System.out.println("#BAB            : [" + BAB + "]");
                    System.out.println("#Combat         : [" + combat + "]");
                    System.out.println("#Damage         : [" + damage + "]");
                    skillPoints();
                } else {
                    BAB = (level * 3) / 4;
                    combat = ((BAB) + calculateBonus(strength[0]));
                    damage = calculateBonus(strength[0]);
                    System.out.println("#BAB            : [" + BAB + "]");
                    System.out.println("#Combat         : [" + combat + "]");
                    System.out.println("#Damage         : [" + damage + "]");
                    skillPoints();
                }

            } else if ((userSelectionCharacter.equals("cleric")) || (userSelectionCharacter.equals("monk")) ||
                    (userSelectionCharacter.equals("rogue")) || (userSelectionCharacter.equals("wizard"))) {

                if (strength[0] >= 16) {
                    BAB = level / 2;
                    combat = ((BAB) + calculateBonus(tempStrength0));
                    damage = calculateBonus(tempStrength0);
                    System.out.println("#BAB            : [" + BAB + "]");
                    System.out.println("#Combat         : [" + combat + "]");
                    System.out.println("#Damage         : [" + damage + "]");
                    skillPoints();
                } else {
                    BAB = level / 2;
                    combat = ((BAB) + calculateBonus(strength[0]));
                    damage = calculateBonus(strength[0]);
                    System.out.println("#BAB            : [" + BAB + "]");
                    System.out.println("#Combat         : [" + combat + "]");
                    System.out.println("#Damage         : [" + damage + "]");
                    skillPoints();
                }
            }
        }
    }

    //contains skill point calculation
    private static void skillPoints() {
        if (userSelectionMethod == 1) {
            if (calculateBonus(stats3) < 0) {
                skillPoints = 1 * level;
                System.out.println("Skill Points : " + skillPoints);
            } else {
                if ((level == 1) && (userSelectionCharacter.equals("barbarian")) || (userSelectionCharacter.equals("druid")) || (userSelectionCharacter.equals("monk"))) {
                    skillPoints = (4 + calculateBonus(stats3)) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if ((userSelectionCharacter.equals("barbarian")) || (userSelectionCharacter.equals("druid")) || (userSelectionCharacter.equals("monk"))) {
                    skillPoints = 4 + calculateBonus(stats3);
                    System.out.println(" Skill Points : " + skillPoints);
                }

                if ((level == 1) && (userSelectionCharacter.equals("bard")) || (userSelectionCharacter.equals("ranger"))) {
                    skillPoints = (6 + calculateBonus(stats3)) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if ((userSelectionCharacter.equals("bard")) || (userSelectionCharacter.equals("ranger"))) {
                    skillPoints = 6 + calculateBonus(stats3);
                    System.out.println(" Skill Points : " + skillPoints);
                }

                if ((level == 1) && (userSelectionCharacter.equals("cleric")) || (userSelectionCharacter.equals("fighter")) || (userSelectionCharacter.equals("paladin")) ||
                        (userSelectionCharacter.equals("sorcerer")) || (userSelectionCharacter.equals("wizard"))) {
                    skillPoints = (2 + calculateBonus(stats3)) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if ((userSelectionCharacter.equals("cleric")) || (userSelectionCharacter.equals("fighter")) || (userSelectionCharacter.equals("paladin")) ||
                        (userSelectionCharacter.equals("sorcerer")) || (userSelectionCharacter.equals("wizard"))) {
                    skillPoints = 2 + calculateBonus(stats3);
                    System.out.println(" Skill Points : " + skillPoints);
                }

                if ((level == 1) && (userSelectionCharacter.equals("rogue"))) {
                    skillPoints = (8 + calculateBonus(stats3)) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if (userSelectionCharacter.equals("rogue")) {
                    skillPoints = 8 + calculateBonus(stats3);
                    System.out.println(" Skill Points : " + skillPoints);
                }

            }

        } else if (userSelectionMethod == 2 || userSelectionMethod == 3 || userSelectionMethod == 4) {
            if (calculateBonus(strength[3]) < 0) {
                skillPoints = 1 * level;
                System.out.println("Skill Points : " + skillPoints);
            } else {
                if ((level == 1) && (userSelectionCharacter.equals("barbarian")) || (userSelectionCharacter.equals("druid")) || (userSelectionCharacter.equals("monk"))) {
                    skillPoints = (4 + calculateBonus(strength[3])) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if ((userSelectionCharacter.equals("barbarian")) || (userSelectionCharacter.equals("druid")) || (userSelectionCharacter.equals("monk"))) {
                    skillPoints = 4 + calculateBonus(strength[3]);
                    System.out.println(" Skill Points : " + skillPoints);
                }

                if ((level == 1) && (userSelectionCharacter.equals("bard")) || (userSelectionCharacter.equals("ranger"))) {
                    skillPoints = (6 + calculateBonus(strength[3])) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if ((userSelectionCharacter.equals("bard")) || (userSelectionCharacter.equals("ranger")) && (level == 1)) {
                    skillPoints = 6 + calculateBonus(strength[3]);
                    System.out.println(" Skill Points : " + skillPoints);
                }

                if ((level == 1) && (userSelectionCharacter.equals("cleric")) || (userSelectionCharacter.equals("fighter")) || (userSelectionCharacter.equals("paladin")) ||
                        (userSelectionCharacter.equals("sorcerer")) || (userSelectionCharacter.equals("wizard"))) {
                    skillPoints = (2 + calculateBonus(strength[3])) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if ((userSelectionCharacter.equals("cleric")) || (userSelectionCharacter.equals("fighter")) || (userSelectionCharacter.equals("paladin")) ||
                        (userSelectionCharacter.equals("sorcerer")) || (userSelectionCharacter.equals("wizard"))) {
                    skillPoints = 2 + calculateBonus(strength[3]);
                    System.out.println(" Skill Points : " + skillPoints);
                }

                if ((level == 1) && (userSelectionCharacter.equals("rogue"))) {
                    skillPoints = (8 + calculateBonus(strength[3])) * 4;
                    System.out.println(" Skill Points : " + skillPoints);
                } else if (userSelectionCharacter.equals("rogue")) {
                    skillPoints = 8 + calculateBonus(strength[3]);
                    System.out.println(" Skill Points : " + skillPoints);
                }
            }

        }
        System.out.println("------------------------------");
        System.out.println("Skills you choose are : ");
        for (String str : selectedArr) {
            System.out.println(str);
        }
    }

    //method to write the summary of the game in a text file
    private static void writing() {
        File outFile = new File(name + ".txt");
        FileWriter fWriter = null;
        try {
            fWriter = new FileWriter(outFile);
            PrintWriter pWriter = new PrintWriter(fWriter);
            pWriter.println("Name            : " + name);
            pWriter.println("Level           : " + level);
            pWriter.println("Character Class : " + userSelectionCharacter);
            pWriter.println("------------------------------");
            pWriter.println("Str : [" + finalStats0 + "][" + finalBonus0 + "]");
            pWriter.println("Dex : [" + finalStats1 + "][" + finalBonus1 + "]");
            pWriter.println("Con : [" + finalStats2 + "][" + finalBonus2 + "]");
            pWriter.println("Int : [" + finalStats3 + "][" + finalBonus3 + "]");
            pWriter.println("Wis : [" + finalStats4 + "][" + finalBonus4 + "]");
            pWriter.println("Cha : [" + finalStats5 + "][" + finalBonus5 + "]");
            pWriter.println("------------------------------");
            pWriter.println("Rank    : " + (3 + level));
            pWriter.println("BAB     : " + BAB);
            pWriter.println("Combat  : " + combat);
            pWriter.println("Damage  : " + damage);
            pWriter.println("Skill points : " + skillPoints);
            pWriter.println("------------------------------");
            pWriter.println("Skills you choose are :");
            for (String str : selectedArr) {
                pWriter.println(str);
            }
            pWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
