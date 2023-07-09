package xray.app.entity;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data

public class Exam {
	@Id 													//indicates primary key for the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//specifying that the value of the identifier will be generated automatically.
	private Long examId;									//represents the unique identifier for the exam
	
	
	// different columns that will be added to the "exam" table with their respected data types.
	private String examName;
	private String examDate;
	private String examTime;
	private String examDuration;
	private String examReason; 
	private String examStatus;
	
	
	
	// The code snippet defines a field named "patients" in a class, which represents
		// the set of patients associated with an entity.
		// The "cascade = CascadeType.PERSIST" configuration specifies that when a new patient
		// is added to the set, it should be persisted in the database.
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude
	@ManyToMany(mappedBy = "exams", cascade = CascadeType.PERSIST) //specifies that the "exams" field is owning side of the relationship.
	private Set<Patient> patients = new HashSet<>();
}
