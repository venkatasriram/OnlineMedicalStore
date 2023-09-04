package com.capg.casestudy.onlinemedicalstore.serviceimpl;

import com.capg.casestudy.onlinemedicalstore.entity.UserDetails;
import com.capg.casestudy.onlinemedicalstore.exception.UserNotFoundException;
import com.capg.casestudy.onlinemedicalstore.repository.UserDetailsRepository;
import com.capg.casestudy.onlinemedicalstore.service.UserDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;
    @Override
    public UserDetails loginUser(String username, String password) {
        Optional<UserDetails> user=userDetailsRepository.findUser(username);
        if(user.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        if(!user.get().getPassword().equals(password)){
            throw new UserNotFoundException("password is incorrect");
        }
        return  user.get();
    }

    @Override
    public UserDetails addUser(UserDetails user) {
        return userDetailsRepository.save(user);
    }

    @Override
    public UserDetails updateUser(UserDetails userDetails) {
        Optional<UserDetails> user=userDetailsRepository.findById(userDetails.getId());
        if(user.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        if(userDetails.getUserName()!=null && userDetails.getUserName().length()>0 && !Objects.equals(user.get().getUserName(),userDetails.getUserName())){
            user.get().setUserName(userDetails.getUserName());
        }
        if(userDetails.getPassword()!=null && userDetails.getPassword().length()>0 && !Objects.equals(user.get().getPassword(),userDetails.getPassword())){
            user.get().setPassword(userDetails.getPassword());
        }
        if(userDetails.getRole()!=null && userDetails.getRole().length()>=0 && !Objects.equals(user.get().getRole(),userDetails.getRole())){
            user.get().setRole(userDetails.getRole());
        }
        if(userDetails.getMobile()!=null && userDetails.getMobile().length()>=0 && !Objects.equals(user.get().getMobile(),userDetails.getMobile())){
            user.get().setUserName(userDetails.getMobile());
        }
        if(userDetails.getAddress()!=null && userDetails.getAddress().length()>=0 && !Objects.equals(user.get().getAddress(),userDetails.getAddress())){
            user.get().setAddress(userDetails.getAddress());
        }
        return user.get();
    }

    @Override
    public void removeUser(int id) {
        Optional<UserDetails> user = userDetailsRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        userDetailsRepository.delete(user.get());
    }

    @Override
    public List<UserDetails> showAllUsers() {
        return userDetailsRepository.findAll();
    }

    @Override
    public UserDetails showUser(int id) {
        Optional<UserDetails> user = userDetailsRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        return user.get();
    }
}
