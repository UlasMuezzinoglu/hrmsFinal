package ulas.hrmsDemo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ulas.hrmsDemo.business.abstracts.VerifyCodeService;
import ulas.hrmsDemo.core.utilities.results.Result;

@RestController
@RequestMapping("/api/aktivasyon/")
public class VerifyController {
    private VerifyCodeService verifyCodeService;

    @Autowired
    public VerifyController(VerifyCodeService verifyCodeService){
        this.verifyCodeService = verifyCodeService;
    }

    @PutMapping("{code}")

    public ResponseEntity<Result> updateStatus(@PathVariable String code){
        var result = verifyCodeService.verifyUser(code);
        if (result.isSuccess()){
            return ResponseEntity.ok(result);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
