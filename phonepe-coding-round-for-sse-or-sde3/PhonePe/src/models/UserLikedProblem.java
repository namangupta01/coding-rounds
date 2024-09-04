package models;

public class UserLikedProblem {
    private User user;
    private Problem problem;

    public UserLikedProblem(User user, Problem problem) {
        this.user = user;
        this.problem = problem;
    }

    public User getUser() {
        return user;
    }

    public Problem getProblem() {
        return problem;
    }
}
