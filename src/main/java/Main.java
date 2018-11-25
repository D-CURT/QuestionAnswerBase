import dao.impl.hibernate.RelationsDAO;
import dao.impl.hibernate.UserDAO;
import entities.Relations;
import entities.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*JDBCUserImpl jdbc = new JDBCUserImpl();
        System.out.println(jdbc.addUser("Alex"));
        //System.out.println(jdbc.removeUser("Alex"));
        //System.out.println(jdbc.removeQuestion("How are you?", "Alex"));
        //System.out.println(jdbc.getFullData());
        System.out.println(jdbc.askQuestion("Alex", "How are you?"));
        System.out.println(jdbc.askQuestion("Alex", "What are you doing?"));
        System.out.println(jdbc.answerQuestion("What are you doing?", "i`m going home", "Alex"));
        System.out.println(jdbc.answerQuestion("How are you?", "i`m fine, thanks", "Alex"));*/
        //System.out.println(SQLSection.ADD_QUESTION.name());
        //System.out.println(UserDAO.getUser(3).getQuestions());
        UserDAO.addUser(new User("Fred"));
        //System.out.println(UserDAO.getUser("wru3e").getId());
        //RelationsDAO.askQuestion("Alex", "What is going on with you?");
        //RelationsDAO.answerQuestion("Alex", "What is going on with you?", "I`m talking with you");
        //UserDAO.removeUser("Fred");
        List<Relations> relations = RelationsDAO.getRelations();
        for (Relations relation: relations) {
            System.out.println(relation);
        }

//        RelationsDAO.askQuestion("Fred", "Do you want to play with me?");
//        RelationsDAO.answerQuestion("Fred", "Do you want to play with me?", "Sorry, but not now");
        UserDAO.removeUser("Fred");
    }
}