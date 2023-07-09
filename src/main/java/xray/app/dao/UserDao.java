package xray.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xray.app.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
