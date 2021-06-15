package ulas.hrmsDemo.core.utilities.cloudinary;

import org.springframework.web.multipart.MultipartFile;
import ulas.hrmsDemo.core.utilities.results.DataResult;

public interface CloudinaryService {
    DataResult<?> save(MultipartFile file);
}
