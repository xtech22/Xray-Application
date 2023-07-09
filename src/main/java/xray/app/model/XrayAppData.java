package xray.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import xray.app.entity.Exam;
import xray.app.entity.Image;
import xray.app.entity.Patient;
import xray.app.entity.User;

@Data
@NoArgsConstructor
public class XrayAppData {
			private Long userId;
			private String userName;
			private String userRole;
			private String userPassword;
			
	public XrayAppData(User user) {
			this.userId = user.getUserId();
			this.userName = user.getUserName();
			this.userRole = user.getUserRole();
			this.userPassword = user.getUserPassword();
		}
	
			private Long patientId;
			private String patientName; 
			private String patientDOB; 
			private String patientGender; 
			private String patientMRN;
			
	public XrayAppData(Patient patient) {
			this.patientId = patient.getPatientId();
			this.patientName = patient.getPatientName();
			this.patientDOB = patient.getPatientDOB();
			this.patientGender = patient.getPatientGender();
			this.patientMRN = patient.getPatientMRN();
			
	}
			private Long examId;
			private String examName;
			private String examDate;
			private String examTime; 
			private String examDuration; 
			private String examReason; 
			private String examStatus;
			
	public XrayAppData(Exam exam) {
			this.examId = exam.getExamId();
			this.examName = exam.getExamName();
			this.examDate = exam.getExamDate();
			this.examTime = exam.getExamTime();
			this.examDuration = exam.getExamDuration();
			this.examReason = exam.getExamReason();
			this.examStatus = exam.getExamStatus();
		
	}
			private Long imageId;
			private String imageFileName;
			private String imageTimestamp;
			private String imageNumber; 
			private String imageSent;
			
	public XrayAppData(Image image) {
			this.imageId = image.getImageId();
			this.imageFileName = image.getImageFileName();
			this.imageTimestamp = image.getImageTimeStamp();
			this.imageNumber = image.getImageNumber();
			this.imageSent = image.getImageSent(); 
	}
}