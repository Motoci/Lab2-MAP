package controller;

import model.User;
import repository.UserRepository;

import java.util.Optional;

public class UserController {
    UserRepository userRepository = new UserRepository();

    public Optional<User> findById(long _id) {
        return userRepository.findById(_id);
    }

    public Optional<User> addUser(User _user) {
        return userRepository.addUser(_user);
    }

    public boolean deleteUser(long _id) {
        return userRepository.deleteUser(_id);
    }

    public boolean updateUser(String _name, long _id) {
        return userRepository.updateUser(_name, _id);
    }
}
