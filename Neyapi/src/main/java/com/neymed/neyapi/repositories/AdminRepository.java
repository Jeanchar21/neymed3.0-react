package com.neymed.neyapi.repositories;


import com.neymed.neyapi.models.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admins, String> {
    UserDetails findByLogin(String login);
}
