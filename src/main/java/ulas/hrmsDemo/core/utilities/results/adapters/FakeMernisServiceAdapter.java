package ulas.hrmsDemo.core.utilities.results.adapters;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FakeMernisServiceAdapter implements UserCheckService{
    @Override
    public boolean isPersonReal(String identityNumber, String firstName, String lastName, int birtOfYear) {
        return true;
    }
}
