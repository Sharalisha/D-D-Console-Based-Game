import java.util.*;
import java.io.*;

public class Skills {
    public static LinkedList<String> list = new LinkedList<String>();

    //method to read the skills from skills.txt
    public static void skills() throws IOException {
        list.clear();
        String content = new String();
        int num = 1;

        File file = new File("skills.txt");

        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                list.add(content);
            }
            sc.close();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nEnded ended properly!!!");
        }

        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.print((num++) + " : ");
            System.out.println(i.next());
            System.out.println(" ");
        }
    }

    //method to read the characters from character.txt
    public static void character() throws IOException {
        list.clear();
        String content = new String();

        File file = new File("character.txt");

        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            while (sc.hasNextLine()) {
                content = sc.nextLine();
                list.add(content);
            }
            sc.close();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nEnded ended properly!!!");
        }

        Iterator i = list.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}

