import java.util.ArrayList;
import java.util.List;

public class CompositeIssue implements Issue {
    private String title;
    
    private List<Issue> subIssues = new ArrayList<>();

    public CompositeIssue(String title) {
        this.title = title;
    }

    public void add(Issue issue) {
        subIssues.add(issue);
    }

    public void remove(Issue issue) {
        subIssues.remove(issue);
    }

    @Override
    public void showDetails() {
        System.out.println("\n=== [Issue Group]: " + title + " ===");
        
        for (Issue issue : subIssues) {
            issue.showDetails(); 
        }
    }
}