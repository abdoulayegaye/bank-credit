package com.bank.credit.bankcredit.controller;

import com.bank.credit.bankcredit.annotation.IsAdmin;
import com.bank.credit.bankcredit.domain.Credit;
import com.bank.credit.bankcredit.service.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/credits")
@AllArgsConstructor
public class CreditController {

    CreditService creditService;

    @GetMapping
    public List<Credit> getCredits() {
        return creditService.getCredits();
    }

    @GetMapping("/{creditNumber}")
    public ResponseEntity<Credit> getCredit(@PathVariable("creditNumber") String creditNumber) {
        return ResponseEntity.ok(creditService.getCredit(creditNumber));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @IsAdmin
    public ResponseEntity<Credit> createCredit(@Valid @RequestBody Credit credit) {
        return new ResponseEntity<>(creditService.createCredit(credit), HttpStatus.CREATED);
    }

    @PutMapping("/{creditNumber}")
    //@IsAdmin
    public Credit updateCredit(@PathVariable("creditNumber") String creditNumber, @Valid @RequestBody Credit credit) {
        return creditService.updateCredit(creditNumber, credit);
    }

    @DeleteMapping("/{creditNumber}")
    //@IsAdmin
    public void deleteCredit(@PathVariable("creditNumber") String creditNumber) {
        creditService.deleteCredit(creditNumber);
    }
}
