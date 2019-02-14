import java.util.ArrayList;
/**
 * stores when a successful login takes place
 * stores the correct user login details
 * @author Alice Jaffray and Kieran D'Arcy
 * @version 2019/02/12v2
 */
public class AuthServer {
    private ArrayList<User> loginDetails;
    private ArrayList<LoginRecord> loginRecords;

    /**
     * constructor
     */
    public AuthServer() {
        loginDetails = new ArrayList<>();
        loginRecords = new ArrayList<>();
    }

    /**
     * authenticates the user for login purposes
     * @param name username of user
     * @param password password of user
     * @return true if the user is verified
     */
    public User authenticate(String name, String password) {
        for(User users : loginDetails) {
            if(users.getUsername().equals(name) && users.getPassword().equals(password)) {
                loginRecords.add(new LoginRecord(name));
                return users;
            }
        }
        return null;
    }

    /**
     * adds authentication details to the server
     * @param name username of user
     * @param password password of user
     */
    public void addDetails(String type, String name, String password) {
        //for testing
        //switch () {}
        loginDetails.add(new User(name, password));
    }

    /**
     * removes details from auth server
     * @param name username of te user
     * @param password password of the user
     */
    public void removeDetails(String name, String password){
        for (User users : loginDetails) {
            if(users.getUsername().equals(name) && users.getPassword().equals(password)) {
                loginDetails.remove(users);
                System.out.println("User '" + name + "' as been removed");
                break;
            }
        }
    }

    public ArrayList<LoginRecord> getLoginRecords() {
        return loginRecords;
    }
}

