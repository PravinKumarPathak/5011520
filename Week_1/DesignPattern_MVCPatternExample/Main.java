package MVCPatternExample;

public class Main {
    public static void main(String[] args) {
        // Create a Student model
        Student student = new Student("John Doe", 1, "A");

        // Create a StudentView
        StudentView view = new StudentView();

        // Create a StudentController
        StudentController controller = new StudentController(student, view);

        // Update the view with current student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Update the view again with updated student details
        controller.updateView();
    }
}


class Student {
    private String name;
    private int id;
    private String grade;

    public Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(String studentName, int studentId, String studentGrade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(int id) {
        model.setId(id);
    }

    public int getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

