package sms;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Course: "); String course = sc.nextLine();
                    dao.addStudent(new Student(id, name, age, course));
                }
                case 2 -> {
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) System.out.println("⚠️ No students found!");
                    else students.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter ID to search: "); int id = sc.nextInt();
                    Student s = dao.getStudentById(id);
                    if (s != null) System.out.println("🎯 Found: " + s);
                    else System.out.println("⚠️ Student not found!");
                }
                case 4 -> {
                    System.out.print("Enter ID to update: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter new Name: "); String name = sc.nextLine();
                    System.out.print("Enter new Age: "); int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter new Course: "); String course = sc.nextLine();
                    dao.updateStudent(new Student(id, name, age, course));
                }
                case 5 -> {
                    System.out.print("Enter ID to delete: "); int id = sc.nextInt();
                    dao.deleteStudent(id);
                }
                case 6 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}
