import java.util.List;

public interface UserServices {

        public User verifyUser(User user, List<User> users);
    public User register(List<User> users);


    public User login(List<User> users);


    public void logout();
}
