package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.CandicateService;
import ulas.hrmsDemo.business.abstracts.EmailService;
import ulas.hrmsDemo.business.abstracts.VerifyCodeService;
import ulas.hrmsDemo.business.checkHelper.concretes.CandicateCheckHelper;
import ulas.hrmsDemo.core.utilities.results.*;
import ulas.hrmsDemo.core.utilities.results.adapters.UserCheckService;
import ulas.hrmsDemo.dataAccess.abstracts.CandicateDao;
import ulas.hrmsDemo.dataAccess.abstracts.UserDao;
import ulas.hrmsDemo.entities.concretes.Candicate;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class CandicateManager implements CandicateService {

    private CandicateDao candicateDao;
    private EmailService emailService;
    private UserCheckService userCheckService;
    private VerifyCodeService verifyCodeService;
    private UserDao userDao;





    @Autowired
    public CandicateManager(CandicateDao candicateDao, EmailService emailService, UserCheckService userCheckService,VerifyCodeService verifyCodeService, UserDao userDao){

        this.candicateDao = candicateDao;
        this.emailService = emailService;
        this.userCheckService = userCheckService;
        this.verifyCodeService = verifyCodeService;
        this.userDao = userDao;


    }


    @Override
    public DataResult<List<Candicate>> getAll() {
        return new SuccessDataResult<>(this.candicateDao.findAll(),"Veriler Getirildi - Candidate");
    }




    @Override
    public Result register(Candicate candicate) {

        boolean isChecked = this.userCheckService.isPersonReal(candicate.getIdentityNumber(),candicate.getFirstName(),candicate.getLastName(),candicate.getBirthYear());
        //boolean checkFields = CandicateCheckHelper.allFieldsAreReq(candicate);

        String errorMsg = "";
        boolean flag = false;
        if (!isChecked){

          return new ErrorResult("Mernis Doğrulama Hatası Bilgilerinizi Doğru Girin !");

        }
        if (this.userDao.existsByEmail(candicate.getEmail())){

            errorMsg = "Bu Mail Adresi ile İşleşen Zaten Bir Kayıt Var. | ";
            flag = true;

        }
        if (this.candicateDao.existsByIdentityNumber(candicate.getIdentityNumber())){

            errorMsg += "Bu T.C Kimlik Numarası ile İşleşen Zaten Bir Kayıt Var. |";
            flag = true;
        }
        if (!candicate.getPassword().equals(candicate.getPasswordAgain())) {
            errorMsg += "Girdiğiniz Şifreler Birbirleri İle Uyuşmuyor.";
            flag = true;
        }
        if (flag){
            return new ErrorResult(errorMsg);
        }
        this.candicateDao.save(candicate);
        this.verifyCodeService.createVerifyCode(candicate);
        return new SuccessResult(this.emailService.sendEmail(candicate).getMessage());

    }



}
