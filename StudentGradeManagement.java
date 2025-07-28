import java.util.*;

class Student {
    private String name;
    private List<Double> grades;
    private double average;
    private char letterGrade;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public void computeAverageAndLetter() {
        double total = 0;
        for (double g : grades) total += g;
        average = total / grades.size();
        letterGrade = calculateLetter(average);
    }

    private char calculateLetter(double avg) {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else if (avg >= 70) return 'C';
        else if (avg >= 60) return 'D';
        else return 'F';
    }

    @Override
    public String toString() {
        return String.format("%s — Average: %.2f — Grade: %c", name, average, letterGrade);
    }
}

public class StudentGradeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d name: ", i + 1);
            String name = scanner.nextLine();
            Student s = new Student(name);

            System.out.print("How many subjects for " + name + "? ");
            int numSubjects = scanner.nextInt();
            for (int j = 0; j < numSubjects; j++) {
                System.out.printf("Enter grade %d: ", j + 1);
                s.addGrade(scanner.nextDouble());
            }
            scanner.nextLine();
            s.computeAverageAndLetter();
            students.add(s);
        }

        System.out.println("\n--- Final Grade Report ---");
        for (Student s : students) {
            System.out.println(s);
        }

        scanner.close();
    }
}
