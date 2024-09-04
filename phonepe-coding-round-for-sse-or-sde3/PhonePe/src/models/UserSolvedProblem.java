package models;

public class UserSolvedProblem {
    private Problem problem;
    private User user;

    private Long timeTakenInMins;

    private Integer score;

    public UserSolvedProblem(Problem problem, User user, Long timeTakenInMins, Integer score) {
        this.problem = problem;
        this.user = user;
        this.timeTakenInMins = timeTakenInMins;
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public Problem getProblem() {
        return problem;
    }

    public Long getTimeTakenInMins() {
        return timeTakenInMins;
    }

    public Integer getScore() {
        return score;
    }
}
