package services;

import models.Pair;
import models.Problem;
import models.User;
import models.UserLikedProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserLikedProblemService {
    private static UserLikedProblemService userLikedProblemServiceInstance = null;

    List<UserLikedProblem> userLikedProblemList;
    HashMap<User, List<UserLikedProblem>> userToUserLikedProblemMap;
    HashMap<Problem, List<UserLikedProblem>> problemToUserLikedProblemMap;

    private UserLikedProblemService() {
        this.userLikedProblemList = new ArrayList<>();
        this.userToUserLikedProblemMap = new HashMap<>();
        this.problemToUserLikedProblemMap = new HashMap<>();
    }

    public UserLikedProblem likeProblem(Problem problem, User user) {
        UserLikedProblem userLikedProblem = new UserLikedProblem(user, problem);
        this.userLikedProblemList.add(userLikedProblem);
        List<UserLikedProblem> userLikedProblems = this.userToUserLikedProblemMap.getOrDefault(user, new ArrayList<>());
        this.userToUserLikedProblemMap.put(user, userLikedProblems);
        userLikedProblems = this.problemToUserLikedProblemMap.getOrDefault(problem, new ArrayList<>());
        userLikedProblems.add(userLikedProblem);
        this.problemToUserLikedProblemMap.put(problem, userLikedProblems);
        return userLikedProblem;
    }

    public List<Problem> getProblemListSortedBasedOnLikes(List<Problem> problemList) {
        List<Pair<Problem, Integer>> pairs = new ArrayList<>();
        for(int i=0; i<problemList.size(); i++) {
            Problem problem = problemList.get(i);
            pairs.add(new Pair(problem, problemToUserLikedProblemMap.getOrDefault(problem, new ArrayList<>()).size()));
        }
        pairs.sort(new Comparator<Pair<Problem, Integer>>() {
            @Override
            public int compare(Pair<Problem, Integer> o1, Pair<Problem, Integer> o2) {
                return o2.getSecond() - o1.getSecond();
            }
        });

        return pairs.stream().map(Pair::getFirst).collect(Collectors.toList());
    }

    public static UserLikedProblemService getInstance() {
        if(userLikedProblemServiceInstance == null) {
            userLikedProblemServiceInstance = new UserLikedProblemService();
        }
        return userLikedProblemServiceInstance;
    }


}
