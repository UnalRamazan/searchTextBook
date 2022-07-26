import java.io.*;

public class BookReader {
    private final static String fileName = "Textbooks.txt";

    public BookReader(BookLinkedList ll) throws Exception {

        String line;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        Book addBook;

        while ((line = br.readLine()) != null) {
            addBook = new Book(line);
            ll.addNewBook(addBook);
        }
        br.close();
    }
}
