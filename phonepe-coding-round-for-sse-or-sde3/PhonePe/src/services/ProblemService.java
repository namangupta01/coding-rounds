package services;

import enums.Difficulty;
import handlers.FiltersHandler;
import models.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemService {
    private static  ProblemService problemServiceInstance = null;

    private List<Problem> problems;

    private ProblemService() {
        this.problems = new ArrayList<>();
    }

    public Problem addProblem(String name, String description, String tagName, Difficulty difficulty, Integer score) {
        Tag tag = TagService.getInstance().getOrCreateDepartment(tagName);
        Problem problem = new Problem(name, description, difficulty, tag, score);
        this.problems.add(problem);
        return problem;
    }

    public List<Problem> getTopNLikedProblem(Tag tag, Integer n) {
        Filter filter = new Filter("TAG", tag);
        List<Problem> problemList = FiltersHandler.getInstance().filterProblems(List.of(filter), this.problems);
        return UserLikedProblemService.getInstance().getProblemListSortedBasedOnLikes(problemList).stream().limit(n).collect(Collectors.toList());
    }

    public List<Problem> fetchProblems(List<Filter> filters) {
//        System.out.println(problems.get(0).getName() + "inside");
        List<Problem> problemList = FiltersHandler.getInstance().filterProblems(filters, this.problems);
        problemList.sort(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        return problemList;
    }

    public static ProblemService getInstance() {
        if(problemServiceInstance == null) {
            problemServiceInstance = new ProblemService();
        }
        return problemServiceInstance;
    }
}
