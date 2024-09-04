package strategies;

import models.Filter;
import models.Problem;

import java.util.List;

public interface FilteringStrategy {
    public List<Problem> filter(List<Problem> problemList, Filter filter);
}
