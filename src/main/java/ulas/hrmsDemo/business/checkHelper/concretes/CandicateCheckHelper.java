package ulas.hrmsDemo.business.checkHelper.concretes;

import org.springframework.stereotype.Service;
import ulas.hrmsDemo.entities.concretes.Candicate;


public class CandicateCheckHelper {

    public static boolean allFieldsAreReq(Candicate candicate){
        if (candicate.getEmail().strip().isEmpty()
                || candicate.getPassword().strip().isEmpty()
                || candicate.getFirstName().strip().isEmpty()
                || candicate.getLastName().strip().isEmpty()
                || candicate.getIdentityNumber().strip().isEmpty()
                )
        {
            return false;
        }
        return true;
    }

}
