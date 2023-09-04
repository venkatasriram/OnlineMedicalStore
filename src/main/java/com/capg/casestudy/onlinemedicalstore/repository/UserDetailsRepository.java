package com.capg.casestudy.onlinemedicalstore.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.capg.casestudy.onlinemedicalstore.entity.UserDetails;
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
    @Query("select a from UserDetails a where user_name=?1")
    Optional<UserDetails> findUser(String name);
}
