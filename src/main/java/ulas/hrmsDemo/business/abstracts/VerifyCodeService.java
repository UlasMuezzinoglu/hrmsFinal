package ulas.hrmsDemo.business.abstracts;

import ulas.hrmsDemo.core.utilities.results.Result;
import ulas.hrmsDemo.entities.concretes.User;

public interface VerifyCodeService {
    String createVerifyCode(User user);
    Result verifyUser(String code);

}
