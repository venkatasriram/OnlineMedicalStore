package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;
import com.capg.casestudy.onlinemedicalstore.entity.UserDetails;
public interface UserDetailsService {
    public UserDetails loginUser(String username, String password);
    public UserDetails addUser(UserDetails user);
    public UserDetails updateUser(UserDetails user);
    public void removeUser(int id);
    public List<UserDetails> showAllUsers();
    public UserDetails showUser(int id);
}