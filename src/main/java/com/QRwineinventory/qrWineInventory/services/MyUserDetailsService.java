package com.QRwineinventory.qrWineInventory.services;

import com.QRwineinventory.qrWineInventory.models.User;
import com.QRwineinventory.qrWineInventory.models.MyUserDetails;
import com.QRwineinventory.qrWineInventory.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }



    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public boolean deleteUserById(int id) {
        userRepository.deleteById(id);
        Path root = Paths.get("src/main/resources/pictures");
        Optional<User> userFound = getUserById(id);
        User user;
        String filename = "";
        if (userFound.isPresent())
        {
            user = userFound.get();
            filename = user.getProfileImage();
        }
        try {
            Path file = root.resolve(filename);
            return Files.deleteIfExists(file);
        } catch (IOException e) {
            System.out.println("Filename might be empty because no user has been found with this uID");
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public User updateUser(int userId, User user)
    {
        User newUserToDB = new User("", "", false, "", "");
        Optional<User> userFromDB = userRepository.findById(userId);
        if (userFromDB.isPresent()) {
            newUserToDB = userFromDB.get();
        }

        if (Objects.nonNull(user.getUserName())
                && !"".equalsIgnoreCase(
                user.getUserName())) {
            newUserToDB.setUserName(
                    user.getUserName());
        }

//        if (Objects.nonNull(
//                user.getEmail())
//                && !"".equalsIgnoreCase(
//                user.getEmail())) {
//            newUserToDB.setEmail(
//                    user.getEmail());
//        }

        if (Objects.nonNull(user.getPassword())
                && !"".equalsIgnoreCase(
                user.getPassword())) {
            newUserToDB.setPassword(
                    user.getPassword());
        }

        if (Objects.nonNull(user.getProfileImage())
                && !"".equalsIgnoreCase(
                user.getProfileImage())) {
            newUserToDB.setProfileImage(
                    user.getProfileImage());
        }

        return userRepository.save(newUserToDB);
    }
}
