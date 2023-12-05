package com.example.users.service;

import com.example.users.ApiException.ApiException;
import com.example.users.Model.MyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.users.Repsitory.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<MyUser> getAllUser(){

        return userRepository.findAll();
    }
    public void addUser(MyUser myUser){
userRepository.save(myUser);
    }
    public MyUser updateUser(Integer id,MyUser myUser){
        MyUser oldUser=userRepository.findMyUserById(id);
        oldUser.setName(myUser.getName());
        oldUser.setUserName(myUser.getUserName());
        oldUser.setPassword(myUser.getPassword());
        oldUser.setEmail(myUser.getEmail());
        oldUser.setRole(myUser.getRole());
        oldUser.setAge(myUser.getAge());
       return userRepository.save(oldUser);
    }
    public MyUser deleteUser(Integer id){
        MyUser myUser=userRepository.findMyUserById(id);
      userRepository.delete(myUser);
      return myUser;

    }
    public MyUser checkUser(String userName,String password){
      MyUser users = userRepository.pleaseFindMyUserForMe(userName,password);
        if (users.getUserName().equals(userName) && users.getPassword().equals(password)){
return users;        }
        throw  new ApiException(" not found");
    }
    public MyUser getEmail(String email){
         MyUser myUsers = userRepository.findMyUserByEmail(email);
        if (myUsers == null) {
            throw new ApiException("email null");

        }
        return myUsers;
    }
    public List<MyUser> searchUserRole(String role){
        List<MyUser> myUsers =userRepository.findMyUserByRole(role);
        if (myUsers == null) {
            throw new ApiException("role not fund");

        }
        return myUsers;
    }
    public  List<MyUser> searchAge(Integer age){

        List<MyUser> myUsers =userRepository.findByAgeGreaterThanEqual(age);
        if (myUsers == null) {
            throw new ApiException("not user");

        }
        return myUsers;

    }
}
