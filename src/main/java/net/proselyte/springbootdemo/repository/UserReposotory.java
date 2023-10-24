package net.proselyte.springbootdemo.repository;

import net.proselyte.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UserReposotory extends JpaRepository<User, Long> {
    List<User> findAllByName(String name);
}
