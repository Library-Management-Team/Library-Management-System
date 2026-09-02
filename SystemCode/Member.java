package SystemCode;

public class Member {
    private static int nextId = 1;

    private String id;
    private String name;
    private String contactInfo;

    public Member(String name, String contactInfo) {
        id = String.valueOf(nextId++);
        ;
        this.name = name;
        this.contactInfo = contactInfo;
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

}
