import java.util.Locale;

public class LibraryManagementSystem{

    // Data Model
    static class Book{
        int bookId;
        String title;
        String author;
        double price;

        public Book(int bookId, String title, String author, double price){
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.price = price;
        }
    }

    // Task 1: Remove Duplicates In-Place
    public static int removeDuplicates(Book[] books, int n){
        if(n == 0){
            return 0;
        }

        int writeIndex = 1;
        for(int readIndex = 1; readIndex < n; readIndex++){
            if(books[readIndex].bookId != books[writeIndex - 1].bookId){
                books[writeIndex] = books[readIndex];
                writeIndex++;
            }
        }
        return writeIndex;
    }

    // Task 2: Partial Title Search (case-insensitive)
    public static void searchByTitle(Book[] books, int count, String query){
        String lowerQuery = query.toLowerCase(Locale.ROOT);
        System.out.println("Search Results for '" + query + "':");
        boolean found = false;

        for(int i = 0; i < count; i++){
            if(books[i].title.toLowerCase(Locale.ROOT).contains(lowerQuery)){
                System.out.printf("- Found: [%d] %s (Rs. %.1f)%n",
                        books[i].bookId, books[i].title, books[i].price);
                found = true;
            }
        }

        if(!found){
            System.out.println("No books found matching '" + query + "'.");
        }
    }

    // Task 3: Sort by Price (Selection Sort)
    public static void sortByPrice(Book[] books, int count){
        int swaps = 0;

        for(int i = 0; i < count - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < count; j++){
                if(books[j].price < books[minIndex].price){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                Book temp = books[i];
                books[i] = books[minIndex];
                books[minIndex] = temp;
                swaps++;
            }
        }

        System.out.println("Books Sorted by Price:");
        for(int i = 0; i < count; i++){
            System.out.printf("%d. [%d] %s - Rs. %.1f%n",
                    i + 1, books[i].bookId, books[i].title, books[i].price);
        }
        System.out.println("Total Swaps: " + swaps);
    }

    // Task 4: Search by Price (Binary Search, O(log N))
    public static int searchByPrice(Book[] books, int count, double targetPrice){
        int low = 0, high = count - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(Double.compare(books[mid].price, targetPrice) == 0){
                return mid;
            }
            else if(books[mid].price < targetPrice){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    //  Task 5: Minimum Consecutive Books for Target Cost (Sliding Window)

    public static int minBooksForTargetCost(Book[] books, int count, double targetCost){
        int left = 0;
        double currentSum = 0.0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < count; right++){
            currentSum += books[right].price;

            while(currentSum >= targetCost){
                int windowLength = right - left + 1;
                if(windowLength < minLength){
                    minLength = windowLength;
                }
                currentSum -= books[left].price;
                left++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    // Helper: print current book list
    private static void printBookList(Book[] books, int count){
        for(int i = 0; i < count; i++){
            System.out.printf("[%d] %s - Rs. %.1f%n",
                    books[i].bookId, books[i].title, books[i].price);
        }
    }

    //  Main: drives the sample test case
    public static void main(String[] args) {
        Book[] books = new Book[]{
                new Book(101, "Data Structures", "Mark", 400.0),
                new Book(101, "Data Structures", "Mark", 400.0), // duplicate
                new Book(102, "Java Basics", "James", 300.0),
                new Book(103, "Python Guide", "Guido", 600.0),
                new Book(104, "Database Systems", "Raghu", 500.0),
                new Book(105, "Computer Networks", "Andrew", 700.0)
        };
        int n = books.length;

        // Task 1
        int uniqueCount = removeDuplicates(books, n);
        System.out.println("1. After Task 1 (Remove Duplicates):");
        System.out.println("Unique Books Count: " + uniqueCount);
        System.out.println("Book List:");
        printBookList(books, uniqueCount);
        System.out.println();

        // Task 2
        System.out.println("2. After Task 2 (Search Query: \"data\"):");
        searchByTitle(books, uniqueCount, "data");
        System.out.println();

        // Task 3
        System.out.println("3. After Task 3 (Sort by Price):");
        sortByPrice(books, uniqueCount);
        System.out.println();

        // Task 4
        double targetPrice = 500.0;
        System.out.println("4. After Task 4 (Search for Price: " + targetPrice + "):");
        System.out.println("Searching for Price Rs. " + targetPrice + "...");
        int priceIndex = searchByPrice(books, uniqueCount, targetPrice);
        if(priceIndex != -1){
            System.out.printf("Result: Book found at index %d: [%d] %s (Rs. %.1f)%n",
                    priceIndex, books[priceIndex].bookId, books[priceIndex].title, books[priceIndex].price);
        }
        else{
            System.out.println("Result: Book not found.");
        }
        System.out.println();

        // Task 5
        double targetCost = 1000.0;
        System.out.println("5. After Task 5 (Sliding Window for Target Cost S = Rs. " + targetCost + "):");
        System.out.println("Finding minimum consecutive books whose total price >= Rs. " + targetCost + "...");
        int minBooks = minBooksForTargetCost(books, uniqueCount, targetCost);
        System.out.println("Minimum Consecutive Books Needed: " + minBooks);
    }
}
