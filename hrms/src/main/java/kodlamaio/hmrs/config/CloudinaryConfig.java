package kodlamaio.hmrs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.Cloudinary.CloudinaryManager;
import kodlamaio.hmrs.core.Cloudinary.CloudinaryService;

@Configuration 
public class CloudinaryConfig {

	@Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ddjzhbvp4",
                "api_key", "796161433729848",
                "api_secret","0_9-T1LlXWVU7UeLfW0HatoKfHI" ));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }
}
