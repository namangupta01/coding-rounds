import enums.Difficulty;
import models.Filter;
import models.Problem;
import models.Tag;
import models.User;
import services.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainService.getInstance();
        Tag tag1 = TagService.getInstance().getOrCreateDepartment("TAG1");
        Tag tag2 = TagService.getInstance().getOrCreateDepartment("TAG2");
        Problem problem = ProblemService.getInstance().addProblem("Problem1", "Desc1", "TAG1", Difficulty.HARD, 100);
        Problem problem2 = ProblemService.getInstance().addProblem("Problem2", "Desc2", "TAG2", Difficulty.HARD, 1250);
        User user = UserService.getInstance().addUser("NAMAN", "TECH");
        User user2 = UserService.getInstance().addUser("NAMAN Gupta", "TECH");
        UserSolvedProblemService.getInstance().solve(problem, user, 100L);
        UserSolvedProblemService.getInstance().solve(problem2, user2, 50L);
//        System.out.println(UserSolvedProblemService.getInstance().fetchSolvedProblems(user));
//        System.out.println(UserSolvedProblemService.getInstance().getLeader().getName());
        System.out.println(ProblemService.getInstance().fetchProblems(List.of(new Filter<Tag>("TAG", tag1 ))).size());
    }
}
