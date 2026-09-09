package SystemCode;

public class Member {
    private static int nextId = 1;

    private String id;
    private String name;
    private String contactInfo;
    private MembershipTier membershipTier;

    public Member(String name, String contactInfo, MembershipTier membershipTier) {
        id = String.valueOf(nextId++);
        this.name = name;
        this.contactInfo = contactInfo;
        this.membershipTier = membershipTier;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public MembershipTier getTier(){
        return membershipTier;
    }

}
