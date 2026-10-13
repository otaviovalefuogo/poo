public class Main {
    public static void main(String[] args) {
        
 
        Issue bugFix = new SimpleIssue("Fix login bug", "Check null pointer exception", "2026-04-24");
        Issue updateDocs = new SimpleIssue("Update documentation", "Add new API endpoints", "2026-04-25");

        CompositeIssue sprintTasks = new CompositeIssue("Sprint 1 Tasks");
        sprintTasks.add(bugFix);
        sprintTasks.add(updateDocs);

        bugFix.showDetails();

        sprintTasks.showDetails();
    }
}