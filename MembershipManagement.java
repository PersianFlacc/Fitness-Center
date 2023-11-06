import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    final private Scanner reader = new Scanner(System.in);
    LinkedList<Member> m = new LinkedList<>();

    private int getIntInput() {
        int number = 0;
        boolean validInput = false;

        while (!validInput) {
            if (reader.hasNextInt()) {
                number = reader.nextInt();
                validInput = true;
            } else {
                reader.next();
            }
        }
        return number;
    }

    private void printClubOptions() {
        System.out.println("Club Mercury");
        System.out.println("Club Neptune");
        System.out.println("Club Jupiter");
        System.out.println("Multi Clubs");
        System.out.print("Please select a club (or enter -1 to quit): ");
    }

    public int getChoice() {
        int choice;
        do {
            System.out.println("WELCOME TO OZONE FITNESS CENTER");
            System.out.println("================================");
            System.out.println("1) Add Member");
            System.out.println("2) Remove Member");
            System.out.println("3) Display Member Information");
            System.out.print("Please select an option (or enter -1 to quit): ");
            choice = getIntInput();
            if (choice == -1 || (choice >= 1 && choice <= 3)) {
                break;
            } else {
                System.out.println("Please try again. Your input incorrectly.");
            }
        } while (true);
        return choice;
    }

    public Member addMembers(LinkedList<Member> m) {

        String name;
        int club;
        String mem;
        double fees;
        int memberID;
        Member mbr;
        Calculator cal;
        final int MembershipPoints = 100;

        do {
            printClubOptions();
            club = getIntInput();
            if (club >= 1 && club <= 4) {
                break;
            } else if (club == -1) {
                break;
            } else {
                System.out.println("Please try again. Your club ID incorrectly");
            }
        } while (true);

        cal = (int x) -> switch (x) {
            case 1 -> 900;
            case 2 -> 950;
            case 3 -> 1000;
            case 4 -> 1200;
            default -> -1;
        };

        fees = cal.calculateFees(club);

        do {
            System.out.println("Enter your name: ");
            name = reader.nextLine();
            if (name.equals("")){
                System.out.println("Your name can't be empty!");
            } else {
                break;
            }
        }while (true);

        int lastID = m.size()+1;
        memberID = 1;
        for(int i = 1; i <= lastID; i++){
            int Id = i;
            if(m.stream().anyMatch(x->x.getMemberID() == Id)){
                continue;
            }
            memberID = i;
            break;
        }

        if(club==4){
            mbr = new MultiClubMember('m', memberID, name, fees, MembershipPoints);
        }else{
            mbr = new SingleClubMember('s', memberID, name, fees, club);
        }
        m.add(mbr);
        return mbr;
    }

    public void removeMember(LinkedList<Member> m) {

        int memberID;

        if (m.size() == 0) {
            System.out.println("Sorry, but members not found!");
            return;
        }

        System.out.println("Enter the ID of the member you want to delete: ");
        memberID = getIntInput();

        for (Member member : m) {
                if (member.getMemberID() == memberID) {
                    m.remove(member);
                    System.out.println("Member this the ID " + memberID + " has been deleted.");
                    break;
                }
        }
    }

    public void printMemberInfo(LinkedList<Member> m) {

        int memberID;

        if (m.size() == 0) {
            System.out.println("Sorry, but members not found!");
            return;
        }

        System.out.println("Enter the ID of the member you want to get information about: ");
        memberID = getIntInput();

        for (Member member : m) {
            if (member.getMemberID() == memberID) {
                System.out.println(member.toString());
                break;
            }
        }
    }
}