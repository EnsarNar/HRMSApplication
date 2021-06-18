package kodlamaio.hmrs.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
	
	@Bean
	//pom.xml'de kerekli kodları ekleyerek bu sistemi import ettik.
	//Modal mapperi newleyip çalıştıran metodu burada yazdık, ileride kullanacagız.
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
