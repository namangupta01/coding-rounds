package services;

public class QuestionService {
    private static  QuestionService questionServiceInstance = null;

    private QuestionService() {
    }

    public static QuestionService getInstance() {
        if(questionServiceInstance == null) {
            questionServiceInstance = new QuestionService();
        }
        return questionServiceInstance;
    }
}
