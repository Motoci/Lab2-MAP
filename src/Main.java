import controller.UserController;
import model.Role;
import model.User;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setRole(Role.ADMIN);

        UserController userController = new UserController();
        System.out.println((userController.addUser(user)).get());
        System.out.println(userController.updateUser("KBD", 1));
        userController.deleteUser(1);
    }
}