public class Student {
    private String name;
    private String rollNumber;
    private String grade;
    private String email;
    private String phone;

    public Student(String name, String rollNumber, String grade, String email, String phone) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + ", Email: " + email + ", Phone: " + phone;
    }
}
