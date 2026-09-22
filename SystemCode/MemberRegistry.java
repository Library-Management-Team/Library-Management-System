package SystemCode;

import java.util.ArrayList;

public class MemberRegistry {

    private ArrayList<Member> members = new ArrayList<>();

    public Member registerMember(String name, String contactInfo, MembershipTier membershipTier) {
        Member member = new Member(name, contactInfo, membershipTier);
        members.add(member);
        return member;
    }

    public boolean isMemberRegistered(Member member) {
        for (Member currentMember : members) {
            if (currentMember.getId().equals(member.getId())) {
                return true;
            }
        }
        return false;
    }

}
