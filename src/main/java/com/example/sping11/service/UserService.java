package com.example.sping11.service;


import com.example.sping11.controller.UserController;
import com.example.sping11.entity.ResponseDto;
import com.example.sping11.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.IntStream.builder;

@Service
public class UserService {

    List<User> users = new ArrayList<>();


    public ResponseDto<User> getById(Integer id) {
        Optional<User> findUser = users.stream().filter(user -> user.getId().equals(id)).findFirst();

        return ResponseDto.<User>builder()
                .data(findUser.orElse(null))
                .code(findUser.isPresent() ? 0 : -1)
                .message(findUser.isPresent() ? "OK" : "Product with this ID is not found")
                .success(true)
                .build();
    }

    public ResponseDto<User> add(User adduser) {
        if (users.stream().anyMatch(users1 -> users1.getId().equals(adduser.getId()))) {
            return ResponseDto.<User>builder()
                    .message("User ID already exists")
                    .code(1)
                    .build();
        }

        if (adduser.getCash() < 0D && adduser.getName().length() == 0 && adduser.getSurname().length() == 0) {
            return ResponseDto.<User>builder()
                    .message("Ma'lumot to'g'ri emas")
                    .code(-1)
                    .build();
        }

        users.add(adduser);

        return ResponseDto.<User>builder()
                .code(0)
                .message("OK")
                .data(adduser)
                .success(true)
                .build();
    }


    public ResponseDto<User> delete(Integer id) {
        Optional<User> deleteUser = users.stream().filter(u -> u.getId().equals(id)).findFirst();


        return ResponseDto.<User>builder()
                .success(deleteUser.isPresent() && users.remove(deleteUser.get()))
                .message(deleteUser.isPresent() ? "OK" : "Not Found")
                .data(deleteUser.orElse(null))
                .code(deleteUser.isPresent() ? 0 : -1)
                .build();
    }

    public ResponseDto<User> update(User user) {
        Optional<User> updateUser = users.stream().filter(u -> u.getId().equals(user.getId())).findFirst();


        if (user.getCash() < 0D && user.getName().length() == 0 && user.getSurname().length() == 0) {
            return ResponseDto.<User>builder()
                    .message("Ma'lumot to'g'ri emas")
                    .code(-1)
                    .build();
        }

        return ResponseDto.<User>builder()
                .success(updateUser.isPresent())
                .message(updateUser.isPresent() ? "OK" : "Not Found")
                .data(updateUser.map(value -> users.set(users.indexOf(value), user)).orElse(null))
                .code(updateUser.isPresent() ? 0 : -1)
                .build();
    }

    public ResponseDto<User> filling(Integer id, Double fillingAmount) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setCash(user.getCash() + fillingAmount);
                return ResponseDto.<User>builder()
                        .code(0)
                        .message("OK")
                        .success(true)
                        .data(user)
                        .build();
            }
        }

        return ResponseDto.<User>builder()
                .code(-1)
                .message("Not Found")
                .build();

    }
}
