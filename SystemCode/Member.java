package SystemCode;

public class Member {
    private static int nextID = 1;

    private int ID;
    private String name;
    private String contactInfo;

    Member(String name, String contactInfo) {
        ID = nextID++;
        this.name = name;
        this.contactInfo = contactInfo;
    }
    int getId() {
    return ID;
}
}
