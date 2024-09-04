package strategies;

import models.Filter;
import models.Problem;

import java.util.List;
import java.util.stream.Collectors;

public class ScoreFilter  implements FilteringStrategy{
    @Override
    public List<Problem> filter(List<Problem> problemList, Filter filter) {
        return problemList.stream().filter(problem -> problem.getScore() == filter.getValue()).collect(Collectors.toList());
    }
}
