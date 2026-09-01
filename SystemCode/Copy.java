package SystemCode;
public class Copy {
    private static int nextCopyId = 1;

    private String copyId;
    private String condition;

    public Copy(String condition) {
        copyId = String.valueOf(nextCopyId++);
        this.condition = condition;
    }
    public String getCopyId() {
        return copyId;
    }
    public String getCondition() {
        return condition;
    }
}