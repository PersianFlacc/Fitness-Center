public class MultiClubMember extends Member{

    private int membershipPoints;

    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints) {
        super(pMemberType, pMemberID, pName, pFees);
        this.membershipPoints = pMembershipPoints;
    }

    public void setMembershipPoints(int pMembershipPoints) {
        this.membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + " MembershipPoints: " + this.membershipPoints;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + ", " + this.membershipPoints;
    }
}
