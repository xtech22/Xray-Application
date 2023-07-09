package xray.app.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import xray.app.dao.ExamDao;
import xray.app.dao.ImageDao;
import xray.app.dao.PatientDao;
import xray.app.dao.UserDao;
import xray.app.entity.Exam;
import xray.app.entity.Image;
import xray.app.entity.Patient;
import xray.app.entity.User;

@Service
public class XrayAppService {
		@Autowired
		private static UserDao userDao;
		@Autowired
		private PatientDao patientDao;
		@Autowired
		private ExamDao examDao; 
		@Autowired
		private ImageDao imageDao; 
		
		
		
		
			//////////"/user" /////////
	//  This method saves any new user that is entered through JSON
		@Transactional(readOnly = false)
		public User saveUser(User user) {
			Long userId = user.getUserId();
			User user1 = findOrCreateUser(userId);
			copyUserFields(user1, user);
			return saveUser(userDao.save(user1));
			
		}

		private void copyUserFields(User user1, User user) {
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			user1.setUserRole(user.getUserRole());
			user1.setUserPassword(user.getUserPassword());
		}


		private User findOrCreateUser(Long userId) {
			User user;
			if(Objects.isNull(userId)) {
				user = new User();
				
			} else {
				user = findUserById(userId);
			}
			return user;
		}


		private User findUserById(Long userId) {

			
			return userDao.findById(userId)
					.orElseThrow(() -> new NoSuchElementException("User with ID=" + userId + " was not found."));
		}
		
		
		
		//////////"/patient" /////////
		@Transactional(readOnly = false)
		public Patient savePatient(Patient patient) {
			Long patientId = patient.getPatientId();
			Patient patient1 = findOrCreatePatient(patientId);
			copyPatientFields(patient1, patient);
			
			return savePatient(patientDao.save(patient1));
			
		}

		private void copyPatientFields(Patient patient1, Patient patient) {
			patient1.setPatientId(patient.getPatientId());
			patient1.setPatientName(patient.getPatientName());
			patient1.setPatientDOB(patient.getPatientDOB());
			patient1.setPatientGender(patient.getPatientGender());
			patient1.setPatientMRN(patient.getPatientMRN());
			
		}

		private Patient findOrCreatePatient(Long patientId) {
			Patient patient;
			if (Objects.isNull(patientId)) {
				patient = new Patient();
			} else {
				patient = findPatientById(patientId);
			}
			return patient;
		}

		private Patient findPatientById(Long patientId) {
			
			return patientDao.findById(patientId) 
					.orElseThrow(() -> new NoSuchElementException("Patient with ID=" + patientId + " was not found."));
			}
		
		
		//////////"/exam" /////////
		@Transactional(readOnly = false)
		public Exam saveExam(Exam exam) {
			Long examId = exam.getExamId();
			Exam exam1 = findOrCreateExam(examId); 
			copyExamFields(exam1, exam);
			
			return saveExam(examDao.save(exam1));
		
		
		
		}

		private void copyExamFields(Exam exam1, Exam exam) {
			exam1.setExamId(exam.getExamId());
			exam1.setExamName(exam.getExamName());
			exam1.setExamDate(exam.getExamDate());
			exam1.setExamTime(exam.getExamTime());
			exam1.setExamDuration(exam.getExamDuration());
			exam1.setExamReason(exam.getExamReason());
			exam1.setExamStatus(exam.getExamStatus());
			
		}

		private Exam findOrCreateExam(Long examId) {
			Exam exam;
			if(Objects.isNull(examId)) {
				exam = new Exam();
			} else {
				exam = findExamById(examId);
			}
			return exam;
		}

		private Exam findExamById(Long examId) {
			return examDao.findById(examId) 
					.orElseThrow(() -> new NoSuchElementException("Exam with ID=" + examId + " was not found."));
		}
		
		
		//////////"/image" /////////
		@Transactional(readOnly = false)
		public Image saveImage(Image image) {
			Long imageId = image.getImageId();
			Image image1 = findOrCreateImage(imageId); 
			copyImageFields(image1, image);
			
			return saveImage(imageDao.save(image1));
		
		
}

		private void copyImageFields(Image image1, Image image) {
			image1.setImageId(image.getImageId());
			image1.setImageFileName(image.getImageFileName());
			image1.setImageTimeStamp(image.getImageTimeStamp());
			image1.setImageNumber(image.getImageNumber());
			image1.setImageSent(image.getImageSent());
			
			
		}

		private Image findOrCreateImage(Long imageId) {
			Image image;
			if(Objects.isNull(imageId)) {
				image = new Image();
			} else {
				image = findImageById(imageId);
			}
			return image;
			
		}

		private Image findImageById(Long imageId) {
			return imageDao.findById(imageId) 
					.orElseThrow(() -> new NoSuchElementException("Image with ID=" + imageId + " was not found."));
		}

		
}









