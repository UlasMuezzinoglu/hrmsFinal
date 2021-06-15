package ulas.hrmsDemo.core.utilities.results.adapters;

import java.time.LocalDate;

public interface UserCheckService {

    boolean isPersonReal(String identityNumber,String firstName, String lastName, int birtOfYear);
}
