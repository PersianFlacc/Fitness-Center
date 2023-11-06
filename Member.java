import java.io.Serializable;

public class Member implements Serializable {

    private char memberType;
    private int memberID;
    private String name;
    private double fees;

    public Member(char pMemberType, int pMemberID, String pName, double pFees) {
        this.memberType = pMemberType;
        this.memberID = pMemberID;
        this.name = pName;
        this.fees = pFees;
    }

    public void setMemberType(char pMemberType) {
        this.memberType = pMemberType;
    }

    public void setMemberID(int pMemberID) {
        this.memberID = pMemberID;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public void setFees(double pFees) {
        this.fees = pFees;
    }

    public char getMemberType() {
        return memberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public double getFees() {
        return fees;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " MemberID: " + this.memberID + " MemberType: " + this.memberType + " Fees: " + this.fees;
    }

    public String toCSV() {
        return this.memberType + ", " + this.memberID + ", " + this.name + ", " + this.fees;
    }
}
