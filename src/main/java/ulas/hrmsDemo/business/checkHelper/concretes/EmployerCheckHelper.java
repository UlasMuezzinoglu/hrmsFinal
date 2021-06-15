package ulas.hrmsDemo.business.checkHelper.concretes;

import ulas.hrmsDemo.entities.concretes.Employer;

public class EmployerCheckHelper {

    public static boolean allFieldReq(Employer employer){
        if (employer.getEmail().strip().isEmpty()
                || employer.getPassword().strip().isEmpty()
                || employer.getCompanyName().strip().isEmpty()
                || employer.getPhoneNumber().strip().isEmpty()
                || employer.getWebAddress().strip().isEmpty())
        {
            return false;
        }
        return true;
    }
}
