import java.util.LinkedList;

public class JavaProject {
    public static void main(String[] args) {

        String mem;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = new LinkedList<>();
        fh.readFile();
        int choice;
        Member member;

        do {
            choice = mm.getChoice();
            switch (choice) {
                case 1:
                    member = mm.addMembers(members);
                    fh.appendFile(member);
                    break;
                case 2:
                    mm.removeMember(members);
                    break;
                case 3:
                    mm.printMemberInfo(members);
                    break;
            }
            if(choice == -1){
                break;
            }
        } while (true);
    }
}
