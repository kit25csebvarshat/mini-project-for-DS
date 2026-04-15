 import java.util.*;

class Student {
    int roll;
    String name;
    int marks;

    Student(int r, String n, int m) {
        roll = r;
        name = n;
        marks = m;
    }
}

public class eg2{
    static Scanner sc = new Scanner(System.in);
    static Student arr[] = new Student[100];
    static int count = 0;

    // Insert
    static void insert() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();

        // check duplicate
        for (int i = 0; i < count; i++) {
            if (arr[i].roll == roll) {
                System.out.println("Duplicate Roll No not allowed!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        arr[count++] = new Student(roll, name, marks);
        System.out.println("Student Added!");
    }

    // Display
    static void display() {
        if (count == 0) {
            System.out.println("Database is empty!");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(arr[i].roll + " " + arr[i].name + " " + arr[i].marks);
        }
    }

    // Selection Sort
    static void sort() {
        for (int i = 0; i < count - 1; i++) {
            int min = i;
            for (int j = i + 1; j < count; j++) {
                if (arr[j].roll < arr[min].roll) {
                    min = j;
                }
            }
            Student temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println("Sorted by Roll No!");
    }

    // Search
    static void search() {
        if (count == 0) {
            System.out.println("Database is empty!");
            return;
        }

        System.out.println("1. Search by Roll\n2. Search by Name");
        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {
            System.out.print("Enter Roll No: ");
            int roll = sc.nextInt();

            for (int i = 0; i < count; i++) {
                if (arr[i].roll == roll) {
                    System.out.println("Found: " + arr[i].name + " " + arr[i].marks);
                    return;
                }
            }
        } else {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            for (int i = 0; i < count; i++) {
                if (arr[i].name.equalsIgnoreCase(name)) {
                    System.out.println("Found: " + arr[i].roll + " " + arr[i].marks);
                    return;
                }
            }
        }
        System.out.println("Student not found!");
    }

    // Delete
    static void delete() {
        if (count == 0) {
            System.out.println("Database is empty!");
            return;
        }

        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (arr[i].roll == roll) {
                for (int j = i; j < count - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                count--;
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Main Menu
    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1.Insert 2.Display 3.Sort 4.Search 5.Delete 6.Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: insert(); break;
                case 2: display(); break;
                case 3: sort(); break;
                case 4: search(); break;
                case 5: delete(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}