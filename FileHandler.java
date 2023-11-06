import java.io.*;
import java.util.*;

public class FileHandler {

    LinkedList<Member> members = new LinkedList<>();

    public LinkedList<Member> readFile() {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("members.csv"))) {
            members = ((LinkedList<Member>) reader.readObject());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("File reading completed!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading stream: " + e.getMessage());
            e.printStackTrace();
        }
        return members;
    }

    public boolean appendFile(Member member) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("members.csv", true))) {
            writer.writeObject(member.toCSV() + "\n");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void owerwriteFile(LinkedList<Member> m) {
        try {
            members.remove(m);
            File file = new File("members.temp");
            file.createNewFile();
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("members.temp"))) {
                objectOutputStream.writeObject(members);
            } catch (IOException e) {
                e.printStackTrace();
            }
            File oldFile = new File("C:\\BD\\members.csv");
            oldFile.delete();
            String newFile = file.getParent() + "\\members.csv";
            file.renameTo(new File(newFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
