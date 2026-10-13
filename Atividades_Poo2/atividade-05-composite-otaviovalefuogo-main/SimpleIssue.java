public class SimpleIssue implements Issue {
    private String title;
    private String description;
    private String dueDate;

    public SimpleIssue(String title, String description, String dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    @Override
    public void showDetails() {
        System.out.println("  [Issue] " + title + " | Due: " + dueDate + " | Desc: " + description);
    }
}