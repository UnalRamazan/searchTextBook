import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BookLinkedList ll = new BookLinkedList();
        BookReader reader = new BookReader(ll);

        int option = 5;
        do {
            printMenu();
            option = scan.nextInt();//get option

            switch (option) {
                case 1://search book with a keyword
                    searchForBook(ll);
                    break;
                case 2://add new book to list
                    addBook(ll);
                    break;
                case 3://print all available books
                    printAllBook(ll);
                    break;
                case 4://save current linked list
                    saveCurrentList(ll);
                    break;
                case 5://exit
                    System.out.println("Goodbye...:)))");
                    break;
                default:
                    System.out.println("Warning... Please try again...");
                    break;
            }
        } while (option != 5);
    }

    private static void searchForBook(BookLinkedList ll) {
        Scanner scan = new Scanner(System.in);
        String searchKeyword = null;
        Book searchResult = null;
        char answer = 'n';

        do {
            System.out.println("Search for a book entry");
            System.out.print("Please enter a portion of title or author that you are looking for: ");
            searchKeyword = scan.nextLine();

            searchResult = ll.search(searchKeyword);

            if (!ll.newResult.isEmpty()) {
                for (String i : ll.newResult) {
                    System.out.println(i);
                }
            } else {
                System.out.println("Warning.. The book you searched for was not found");
            }
            ll.newResult.clear();

            System.out.println("Would you like to run again (y/n)?");
            answer = scan.nextLine().charAt(0);
        } while (answer != 'n');
    }

    public static void addBook(BookLinkedList ll) {
        Scanner scan = new Scanner(System.in);
        String answer;
        Book addBook;

        System.out.println("Please enter book' s name:");
        answer = scan.nextLine();

        addBook = new Book(answer);
        ll.addNewBook(addBook);
    }

    public static void printAllBook(BookLinkedList ll) {
        BookNode walk = ll.getHead();

        while (walk != null) {
            System.out.println(walk.getData().getBookEntry());
            walk = walk.getNext();
        }
    }

    public static void saveCurrentList(BookLinkedList ll) {
        BookWriter writer = new BookWriter(ll);
    }

    private static void printMenu() {
        System.out.println("Book Search Application Menu");
        System.out.println("1.	search book with a keyword");
        System.out.println("2.	add new book to list");
        System.out.println("3.	print all available books");
        System.out.println("4.	save current linked list");
        System.out.println("5.	exit...");
    }
}
