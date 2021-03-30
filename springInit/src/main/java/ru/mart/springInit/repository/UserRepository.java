package ru.mart.springInit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.mart.springInit.model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
