package handlers;

import models.Filter;
import models.Problem;
import strategies.DifficultyLevelFilter;
import strategies.FilteringStrategy;
import strategies.TagFilter;

import java.util.HashMap;
import java.util.List;

public class FiltersHandler {
    private static FiltersHandler filterServiceInstance = null;
    public HashMap<String, FilteringStrategy> filterNameToFilteringStrategyMap;

    private FiltersHandler() {
        this.filterNameToFilteringStrategyMap = new HashMap<>();
        this.filterNameToFilteringStrategyMap.put("TAG", new TagFilter());
        this.filterNameToFilteringStrategyMap.put("DIFFICULTY", new DifficultyLevelFilter());
    }



    public List<Problem> filterProblems(List<Filter> filterList, List<Problem> problems) {
        for(int i=0; i<filterList.size(); i++) {
            Filter filter = filterList.get(i);
            FilteringStrategy filteringStrategy = this.filterNameToFilteringStrategyMap.get(filter.getName());
            problems = filteringStrategy.filter(problems, filter);
        }
        return problems;
    }

    public static FiltersHandler getInstance() {
        if(filterServiceInstance == null) {
            filterServiceInstance = new FiltersHandler();
        }
        return filterServiceInstance;
    }
}
