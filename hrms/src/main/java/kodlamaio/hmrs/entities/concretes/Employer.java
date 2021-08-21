package kodlamaio.hmrs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDefs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.json.JsonType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = false)
@TypeDefs({
    @TypeDef(name = "json", typeClass = JsonType.class)
})
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class Employer extends User{
	
	@NotBlank(message="Şirket adı zorunludur.")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Telefon numarası zorunludur.")
	@Column(name="phone_number")
	private String phoneNumber;
	
	@NotBlank(message="Web adresinizi giriniz.")
	@Column(name="web_adress")
	private String webAdress;
	
	@Column(name="is_activated")
	private boolean isActivated;
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvertisement> jobAdvertisements;
	
	@Type(type = "json")
	@Column(columnDefinition = "json",name = "updated_data")
	private Employer updatedData;
	
}
