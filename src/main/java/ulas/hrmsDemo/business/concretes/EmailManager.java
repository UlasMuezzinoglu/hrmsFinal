package ulas.hrmsDemo.business.concretes;

import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.EmailService;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.entities.concretes.User;

@Service
public class EmailManager implements EmailService {
    @Override
    public Result sendEmail(User user) {
        return new SuccessResult("Aktivasyon Kodu Başarı ile Gönderildi"+" "+ user.getEmail());
    }
}
