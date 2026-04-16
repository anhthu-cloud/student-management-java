import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String id;
    String name;
    int age;

    Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age);
    }
}

public class Main {
    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Add student");
            System.out.println("2. Show students");
            System.out.println("3. Delete student");
            System.out.println("4. Update student");
            System.out.println("5. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        list.add(new Student(id, name, age));
        System.out.println("Added!");
    }

    static void showStudents() {
        if (list.isEmpty()) {
            System.out.println("No students!");
            return;
        }

        for (Student s : list) {
            s.display();
        }
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        String id = sc.nextLine();

        boolean found = list.removeIf(s -> s.id.equals(id));

        if (found) {
            System.out.println("Deleted!");
        } else {
            System.out.println("Student not found!");
        }
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        String id = sc.nextLine();

        for (Student s : list) {
            if (s.id.equals(id)) {
                System.out.print("New name: ");
                s.name = sc.nextLine();

                System.out.print("New age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.println("Updated!");
                return;
            }
        }

        System.out.println("Student not found!");
    }
}