
package java_fitness_club;


public class MultiClubMember extends Member{
    private int membershipPoints;

    public MultiClubMember(char memberType, int memberId, String name, double fees, int membershipPoints) {
        super(memberType, memberId, name, fees);
        this.membershipPoints = membershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int membershipPoints) {
        this.membershipPoints = membershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + membershipPoints;
    }
    
}
