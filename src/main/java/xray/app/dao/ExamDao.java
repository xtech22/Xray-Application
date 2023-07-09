package xray.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xray.app.entity.Exam;

public interface ExamDao extends JpaRepository<Exam, Long> {

}
