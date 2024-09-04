package services;

import handlers.FiltersHandler;

public class MainService {

    public MainService() {
        DepartmentService.getInstance();
        ProblemService.getInstance();
        QuestionService.getInstance();
        UserLikedProblemService.getInstance();
        UserService.getInstance();
        UserSolvedProblemService.getInstance();
        FiltersHandler.getInstance();
    }

    private static  MainService mainServiceInstance = null;

    public static MainService getInstance() {
        if(mainServiceInstance == null) {
            mainServiceInstance = new MainService();
        }
        return mainServiceInstance;
    }
}
