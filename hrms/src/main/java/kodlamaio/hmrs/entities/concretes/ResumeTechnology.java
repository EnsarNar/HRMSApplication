package kodlamaio.hmrs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="resume_technologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeTechnology {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="programming_language_name")
	private String programmingLanguageName;
	
	@Column(name="grade")
	private int grade;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()
	@JoinColumn(name="resume_id")
	private Resume resume;
}
