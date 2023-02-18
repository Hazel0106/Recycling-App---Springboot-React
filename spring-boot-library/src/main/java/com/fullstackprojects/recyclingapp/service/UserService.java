package com.fullstackprojects.recyclingapp.service;

import com.fullstackprojects.recyclingapp.dao.UserRepository;
import com.fullstackprojects.recyclingapp.entity.User;
import com.fullstackprojects.recyclingapp.requestmodels.AddUserRequest;
import com.fullstackprojects.recyclingapp.requestmodels.AdminQuestionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository messageRepository) {
        this.userRepository = messageRepository;
    }

    public void verifyUser(String userEmail) throws Exception {
    }
    public void addUser(AddUserRequest addUserRequest) {
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setUserEmail(addUserRequest.getEmail());
        user.setPassword(addUserRequest.getPassword());
        user.setCity(addUserRequest.getCity());
        user.setImg(addUserRequest.getImg());
        userRepository.save(user);
    }

    public void deleteUser(Long userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new Exception("User is not found or already deleted.");
        }

        userRepository.delete(user.get());
    }

    public void putMessage(AdminQuestionRequest adminQuestionRequest, String userEmail) throws Exception {
        Optional<User> user = userRepository.findById(adminQuestionRequest.getId());
        if (!user.isPresent()) {
            throw new Exception("Message not found");
        }

//        message.get().setAdminEmail(userEmail);
//        message.get().setResponse(adminQuestionRequest.getResponse());
        userRepository.save(user.get());
    }

}
