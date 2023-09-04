package com.capg.casestudy.onlinemedicalstore.service;

import java.util.List;
import com.capg.casestudy.onlinemedicalstore.entity.UserDetails;
public interface UserService {
    public UserDetails loginUser(String Username, String Password);
    public UserDetails addUser(UserDetails user);
    public UserDetails updateUser(UserDetails user);
    public void removeUser(int id);
    public List<UserDetails> showAllUsers();
    public UserDetails showUser(int id);
}