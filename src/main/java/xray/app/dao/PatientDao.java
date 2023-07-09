package xray.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import xray.app.entity.Patient;

public interface PatientDao extends JpaRepository<Patient, Long> {

}
