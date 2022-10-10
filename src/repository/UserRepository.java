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

    public User deleteUser(long _id) {
        Optional<User> userOptional = findById(_id);

        if (userOptional.isEmpty()) {
            System.out.println("User not found for delete");
            return null;
        }

        users.remove(userOptional.get());

        return userOptional.get();
    }

    public User updateUser(String _name, long _id) {
        Optional<User> userOptional = findById(_id);

        if (userOptional.isEmpty()) {
            System.out.println("User for found for update");
            return null;
        }

        User user = userOptional.get();
        user.setName(_name);
        return user; // newUser
    }
}
