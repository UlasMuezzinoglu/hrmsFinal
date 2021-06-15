package ulas.hrmsDemo.business.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ulas.hrmsDemo.core.utilities.cloudinary.CloudinaryManager;
import ulas.hrmsDemo.core.utilities.cloudinary.CloudinaryService;


@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinaryUser() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "prodiggie",
                "api_key", "437796188397975",
                "api_secret", "DVuW6fzjnuBtf3OYYCkYv7lV2k4"));
    }

    @Bean
    public CloudinaryService cloudinaryService() {
        return new CloudinaryManager(cloudinaryUser());
    }
}
