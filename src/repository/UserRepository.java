package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public Optional<User> findById(long _id) {
        return users.stream()
                .filter(user -> user.getId() == _id)
                .findFirst();
    }

    public Optional<User> addUser(User _user) {
        Optional<User> userOptional = findById(_user.getId());

        if (userOptional.isPresent()) {
            System.out.println("User already present");
            return userOptional;
        }

        users.add(_user);
        return Optional.of(_user);
    }

    public boolean deleteUser(long _id) {
        Optional<User> userOptional = findById(_id);

        if (userOptional.isEmpty()) {
            System.out.println("User not found for delete");
            return false;
        }

        users.remove(userOptional.get());
        return true;
    }

    public boolean updateUser(String _name, long _id) {
        Optional<User> userOptional = findById(_id);

        if (userOptional.isEmpty()) {
            System.out.println("User not found for update");
            return false;
        }

        User user = userOptional.get();
        user.setName(_name);
        return true;
    }
}
