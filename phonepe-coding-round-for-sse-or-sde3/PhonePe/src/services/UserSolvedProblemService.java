package services;

import models.Problem;
import models.User;
import models.UserSolvedProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserSolvedProblemService {
    private static UserSolvedProblemService userSolvedProblemServiceInstance = null;
    List<UserSolvedProblem> userSolvedProblemList;
    HashMap<User, List<UserSolvedProblem>> userToUserSolvedProblemMap;

    private UserSolvedProblemService() {
        this.userSolvedProblemList = new ArrayList<>();
        this.userToUserSolvedProblemMap = new HashMap<>();
    }

    public UserSolvedProblem solve(Problem problem, User user, Long timeTakenInMins) {
        UserSolvedProblem userSolvedProblem = new UserSolvedProblem(problem, user, timeTakenInMins, problem.getScore());
        this.userSolvedProblemList.add(userSolvedProblem);
        List<UserSolvedProblem> userSolvedProblems = this.userToUserSolvedProblemMap.getOrDefault(user, new ArrayList<>());
        userSolvedProblems.add(userSolvedProblem);
        this.userToUserSolvedProblemMap.put(user, userSolvedProblems);
        return userSolvedProblem;
    }

    public List<Problem> fetchSolvedProblems(User user) {
        return this.userSolvedProblemList.stream()
                .filter(userSolvedProblem -> userSolvedProblem.getUser() == user)
                .map(UserSolvedProblem::getProblem)
                .toList();
    }

    public User getLeader() {
        HashMap<User, Integer> userToScoreMap = new HashMap<>();
        User maxScoreUser = null;
        Integer maxScore = 0;
        for(User user: this.userToUserSolvedProblemMap.keySet()) {
            Integer score = 0;
            List<UserSolvedProblem> userSolvedProblems = this.userToUserSolvedProblemMap.get(user);
            for(int i=0; i<userSolvedProblems.size(); i++) {
                score += userSolvedProblems.get(i).getScore();
            }
            if(maxScoreUser == null) {
                maxScoreUser = user;
            } else {
                if(score > maxScore) {
                    maxScoreUser = user;
                    maxScore = score;
                }
            }
        }
        return maxScoreUser;
    }


    public static UserSolvedProblemService getInstance() {
        if(userSolvedProblemServiceInstance == null) {
            userSolvedProblemServiceInstance = new UserSolvedProblemService();
        }
        return userSolvedProblemServiceInstance;
    }
}
