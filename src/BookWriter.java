import java.io.*;
import java.util.Scanner;

public class BookWriter {
    Scanner scan = new Scanner(System.in);

    public BookWriter(BookLinkedList ll) {
        BookNode walk = ll.getHead();
        String fileName;

        System.out.print("Please enter your filename: ");
        fileName = scan.next();

        try {
            File f = new File(fileName + ".txt");

            if (f.createNewFile()) {
                System.out.println("The file has been created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        while (walk != null) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", true));
                writer.write(walk.getData().getBookEntry());
                writer.newLine();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            walk = walk.getNext();
        }
    }
}
