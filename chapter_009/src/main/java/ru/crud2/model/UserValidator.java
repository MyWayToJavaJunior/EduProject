package ru.crud2.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nikolay on 25/09/17.
 */
public class UserValidator {
    /**
     * validate user data.
     * @param user - user to validate.
     * @return - result of validation.
     */
    public boolean validate(User user) {
        return nameValid(user.getName())
                && loginValid(user.getLogin())
                && passValid(user.getPassword())
                && mailValid(user.getEmail());
    }
    /**
     * name validate.
     * @param name - name.
     * @return - result of validation.
     */
    private boolean nameValid(String name) {
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        Matcher m = p.matcher(name);
        return m.matches();
    }
    /**
     * login validate.
     * @param login - login.
     * @return - result of validation.
     */
    private boolean loginValid(String login) {
        Pattern p = Pattern.compile("^[a-z]+$");
        Matcher m = p.matcher(login);
        return m.matches();
    }
    /**
     * password validate.
     * @param pass - password.
     * @return - result of validation.
     */
    private boolean passValid(String pass) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_]{3,}$");
        Matcher m = p.matcher(pass);
        return m.matches();
    }
    /**
     * mail validate.
     * @param mail - mail.
     * @return - result of validation.
     */
    private boolean mailValid(String mail) {
        Pattern p = Pattern.compile("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$");
        Matcher m = p.matcher(mail);
        return m.matches();
    }
}
