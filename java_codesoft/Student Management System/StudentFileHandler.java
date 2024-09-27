import java.io.*;
import java.util.List;

public class StudentFileHandler {
    public static void writeStudentsToFile(List<Student> students, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        }
    }

    public static List<Student> readStudentsFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<Student>) ois.readObject();
        }
    }
}
