package com.sidneyspe.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import javax.inject.Inject;
import com.sidneyspe.domain.User;
import com.sidneyspe.repository.UserRepository;


public class UserService {

  private UserRepository userRepository;

  @Inject
  public void setService(UserRepository userRepository) {
      this.userRepository = userRepository;
  }

  public Boolean save(User user) {
    try{
      userRepository.save(user);
      return true;
    }catch(Exception e){
      return false;
    }

  }

}
