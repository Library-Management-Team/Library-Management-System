package SystemCode;
public class Copy {
    private static int nextCopyId = 1;

    private String copyId;
    private String condition;
    private boolean available;

    public Copy(String condition) {
        copyId = String.valueOf(nextCopyId++);
        this.condition = condition;
        available = true;
    }
    public String getCopyId() {
        return copyId;
    }
    public String getCondition() {
        return condition;
    }
    public boolean isAvailable(){
        return available;
    }
    public void markAsBorrowed(){
        available = false;
    }
    public void markAsAvailable() {
    available = true;
}
}