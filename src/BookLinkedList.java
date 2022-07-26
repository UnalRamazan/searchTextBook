import java.util.ArrayList;

public class BookLinkedList {
    private BookNode head;

    public BookNode getHead() {
        return head;
    }

    public BookLinkedList() {
        head = null;
    }

    public void addNewBook(Book item) {
        BookNode newNode = new BookNode(item);

        if (head == null) {
            newNode.setNext(null);
            head = newNode;
        } else {
            BookNode walk = head;
            while (walk.getNext() != null) {
                walk = walk.getNext();
            }
            walk.setNext(newNode);
            newNode.setNext(null);
        }
    }

    ArrayList<String> newResult;

    public Book search(String key) {
        BookNode walk = head;
        Book result = null;
        newResult = new ArrayList<>();

        while (walk != null) {
            if (walk.getData().getBookEntry().toLowerCase().contains(key.toLowerCase())) {
                result = walk.getData();
                newResult.add(result.getBookEntry());
            }
            walk = walk.getNext();
        }
        return result;
    }

    public void saveToTextFile(String fileName) {

    }

    public Book[] toArray() {
        BookNode walk = head;
        int counter = 0;
        Book[] bookArray = new Book[this.getSize()];

        while (walk != null) {
            bookArray[counter] = walk.getData();
            walk = walk.getNext();
            counter++;
        }
        return bookArray;
    }

    public int getSize() {
        int counter = 0;
        BookNode walk = head;
        while (walk != null) {
            counter++;
            walk = walk.getNext();
        }
        return counter;
    }

    public String toString() {
        int counter = 1;
        int size = getSize();
        String str = "{";
        BookNode walk = head;
        while (walk != null) {
            if (counter < size) {
                str += walk.getData() + ",";
                walk = walk.getNext();
            } else if (counter == size) {
                str += walk.getData();
                walk = walk.getNext();
            }
            counter++;
        }
        str += "}";
        return str;
    }
}
