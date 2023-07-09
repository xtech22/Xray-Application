package xray.app.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data
public class Patient {
	@Id 														//Indicates that it is the primary key for the entity.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patientId; 
	
	private String patientName;
	private String patientDOB;
	private String patientGender;
	private String patientMRN;
	
	// The annotation "@JoinTable" specifies the join table name and the columns used for
		// joining the "Patient" and "Exam" entities.
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "patient_exam", joinColumns = @JoinColumn(name = "patient_id"), 
	inverseJoinColumns = @JoinColumn(name = "exam_id"))
	private Set<Exam> exams = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User users;
}
