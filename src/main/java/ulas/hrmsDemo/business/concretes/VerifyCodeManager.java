package ulas.hrmsDemo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ulas.hrmsDemo.business.abstracts.EmailService;
import ulas.hrmsDemo.business.abstracts.VerifyCodeService;
import ulas.hrmsDemo.core.utilities.results.ErrorResult;
import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.core.utilities.results.SuccessResult;
import ulas.hrmsDemo.dataAccess.abstracts.UserDao;
import ulas.hrmsDemo.dataAccess.abstracts.VerifyCodeDao;
import ulas.hrmsDemo.entities.concretes.User;
import ulas.hrmsDemo.entities.concretes.VerifyCode;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class VerifyCodeManager implements VerifyCodeService {


    private UserDao userDao;
    private VerifyCodeDao verifyCodeDao;

    @Autowired
    public VerifyCodeManager(UserDao userDao, VerifyCodeDao verifyCodeDao) {

        this.verifyCodeDao = verifyCodeDao;
        this.userDao = userDao;
    }

    @Override
    public String createVerifyCode(User user) {
        String verifyCode = UUID.randomUUID().toString();
        VerifyCode code = new VerifyCode();
        LocalDate creDate = (LocalDate.now());
        code.setUserId(user);
        code.setCodeCreatedDate(creDate);
        code.setVerifyCode(UUID.randomUUID().toString());
        this.verifyCodeDao.save(code);
        return verifyCode;
    }

    @Override
    public Result verifyUser(String code) {

        if (!this.verifyCodeDao.existsByVerifyCode(code)) {
            return new ErrorResult("Girdiğiniz Doğrulama Kodu Hatalı !");
        }
        VerifyCode verifyCode = verifyCodeDao.getByVerifyCode(code);
        if (this.verifyCodeDao.getOne(verifyCode.getId()).isVerified()) {
            return new ErrorResult("Doğrulama işlemi daha önce yapılmış");
        }
        LocalDate verDate = (LocalDate.now());
        verifyCode.setVerified(true);
        verifyCode.setVerifiedDate(verDate);
        verifyCodeDao.save(verifyCode);
        User verifiedUser;
        verifiedUser = userDao.getOne(verifyCode.getUserId().getId());
        verifiedUser.setVerified(true);
        userDao.save(verifiedUser);
        return new SuccessResult("Doğrulama Başarılı");

    }
}
