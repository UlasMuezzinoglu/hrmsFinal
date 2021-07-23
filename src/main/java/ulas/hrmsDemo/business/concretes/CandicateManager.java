package ulas.hrmsDemo.business.concretes;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.Constants.Messages;
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
        return new SuccessDataResult<>(this.candicateDao.findAll(),Messages.DatasRetriviedForCandidate);
    }




    @Override
    public Result register(Candicate candicate) {

        boolean isChecked = this.userCheckService.isPersonReal(candicate.getIdentityNumber(),candicate.getFirstName(),candicate.getLastName(),candicate.getBirthYear());
        //boolean checkFields = CandicateCheckHelper.allFieldsAreReq(candicate);

        String errorMsg = "";
        boolean flag = false;
        if (!isChecked){

          return new ErrorResult(Messages.MernisFailedAuth);

        }
        if (this.userDao.existsByEmail(candicate.getEmail())){

            errorMsg = Messages.MailIsExisting;
            flag = true;

        }
        if (this.candicateDao.existsByIdentityNumber(candicate.getIdentityNumber())){

            errorMsg += Messages.IdentityNumberIsExisting;
            flag = true;
        }
        if (!candicate.getPassword().equals(candicate.getPasswordAgain())) {
            errorMsg += Messages.PasswordNotMatch;
            flag = true;
        }
        if (flag){
            return new ErrorResult(errorMsg, HttpStatus.SC_BAD_REQUEST);
        }
        this.candicateDao.save(candicate);
        this.verifyCodeService.createVerifyCode(candicate);
        return new SuccessResult(this.emailService.sendEmail(candicate).getMessage());

    }



}
