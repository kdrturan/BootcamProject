package com.BootCampProject.BootCampProject.service.concrete;

import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserAddRequest;
import com.BootCampProject.BootCampProject.service.dtos.requests.user.UserUpdateRequest;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserAddResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetByIdResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserGetListResponse;
import com.BootCampProject.BootCampProject.service.dtos.responses.user.UserUpdatedResponse;
import com.BootCampProject.BootCampProject.entity.User;
import com.BootCampProject.BootCampProject.repository.UserRepository;
import com.BootCampProject.BootCampProject.service.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserAddResponse add(UserAddRequest userAddRequest) {
        User user = new User
                (
                        userAddRequest.getUserName(),userAddRequest.getFirstName(),
                        userAddRequest.getLastName(),userAddRequest.getDateOfBirth(),
                        userAddRequest.getNationalIdentity(),userAddRequest.getEmail(),
                        userAddRequest.getPassword()
                );
        User addedResponse = userRepository.save(user);
        UserAddResponse response = new UserAddResponse(addedResponse.getId(),addedResponse.getUserName());
        return response;
    }

    @Override
    public List<UserGetListResponse> getAll() {
        return userRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    @Override
    public UserUpdatedResponse update(UserUpdateRequest userUpdateRequest) {
        User user = userRepository.findById(userUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserUpdatedResponse response= mapToUserUpdatedResponse(userUpdateRequest,user);
        return response;
    }

    @Override
    public void delete(int id) {
            userRepository.deleteById(id);
    }

    @Override
    public UserGetByIdResponse getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserGetByIdResponse response = new UserGetByIdResponse(user.getId(), user.getUserName(), user.getFirstName(),
                user.getLastName(), user.getDateOfBirth(), user.getNationalIdentity(), user.getEmail());
        return response;
    }




    private UserUpdatedResponse mapToUserUpdatedResponse(UserUpdateRequest userUpdateRequest,User user)
    {
        user.setUserName(userUpdateRequest.getUserName());
        user.setFirstName(userUpdateRequest.getFirstName());
        user.setLastName(userUpdateRequest.getLastName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPassword(userUpdateRequest.getPassword());
        user.setDateOfBirth(userUpdateRequest.getDateOfBirth());
        user.setNationalIdentity(userUpdateRequest.getNationalIdentity());

        User updatedUser = userRepository.save(user);

        UserUpdatedResponse response = new UserUpdatedResponse();
        response.setId(updatedUser.getId());
        response.setUserName(updatedUser.getUserName());
        response.setFirstName(updatedUser.getFirstName());
        response.setLastName(updatedUser.getLastName());
        response.setEmail(updatedUser.getEmail());
        response.setNationalIdentity(updatedUser.getNationalIdentity());
        response.setDateOfBirth(updatedUser.getDateOfBirth());
        return response;
    }


    private UserGetListResponse mapToResponse(User user){
        UserGetListResponse response = new UserGetListResponse();
        response.setId(user.getId());
        response.setUserName(user.getUserName());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
    }
}
