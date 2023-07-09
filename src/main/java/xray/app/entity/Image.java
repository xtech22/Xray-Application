package xray.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data
public class Image {
	@Id 													//indicates primary key for the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY)		//specifying that the value of the identifier will be generated automatically.
	private Long imageId;									//represents the unique identifier for the customer
	
	private String imageFileName;
	private String imageTimeStamp; 
	private String imageNumber; 
	private String imageSent; 
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_id") 		//specifies the mapping of the foreign key column between this entity and the "exam" entity
	private Exam exam;
	
	
}
