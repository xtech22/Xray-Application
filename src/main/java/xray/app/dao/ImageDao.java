package xray.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xray.app.entity.Image;

public interface ImageDao extends JpaRepository<Image, Long>{

}
