package ulas.hrmsDemo.core.utilities.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ulas.hrmsDemo.core.utilities.results.DataResult;
import ulas.hrmsDemo.core.utilities.results.ErrorDataResult;
import ulas.hrmsDemo.core.utilities.results.ErrorResult;
import ulas.hrmsDemo.core.utilities.results.SuccessDataResult;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService {

    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryManager(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public DataResult<?> save(MultipartFile file) {
        try{
            Map cloudinaryUploader = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(cloudinaryUploader);
        } catch (IOException e){
           // return new ErrorDataResult("Hataaaaaaaaaa !");
        }
        return new ErrorDataResult<Map>();
    }
}
