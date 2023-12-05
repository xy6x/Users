package com.example.users.Repsitory;

import com.example.users.Model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Integer> {

    MyUser findMyUserById(Integer id);
   MyUser findMyUserByEmail(String email);
    List<MyUser> findMyUserByRole(String role);

    List<MyUser> findByAgeGreaterThanEqual(Integer age);
    @Query("select  c from MyUser c where c.userName=?1 and c.password=?2")
    MyUser pleaseFindMyUserForMe(String userName,String password);
}
