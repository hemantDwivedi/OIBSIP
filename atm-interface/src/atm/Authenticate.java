package atm;

public class Authenticate {
    boolean isUsernameExist(String username, String databaseUsername){
        return username.equals(databaseUsername);
    }
    boolean isPasswordExist(String password, String databasePassword){
        return password.equals(databasePassword);
    }
}