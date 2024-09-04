package strategies;

import models.Filter;
import models.Problem;

import java.util.List;
import java.util.stream.Collectors;

public class TagFilter implements FilteringStrategy{
    @Override
    public List<Problem> filter(List<Problem> problemList, Filter filter) {
//        System.out.println(problemList.get(0).getTag().getName());
//        System.out.println(filter.getValue());
        return problemList.stream().filter(problem -> problem.getTag() == filter.getValue()).collect(Collectors.toList());
    }
}
