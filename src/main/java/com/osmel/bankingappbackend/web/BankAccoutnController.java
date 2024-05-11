package com.osmel.bankingappbackend.web;

import com.osmel.bankingappbackend.dtos.AccountHistDto;
import com.osmel.bankingappbackend.dtos.BankAccountDto;
import com.osmel.bankingappbackend.dtos.BankOperationDto;
import com.osmel.bankingappbackend.entities.BankOperation;
import com.osmel.bankingappbackend.exceptions.AccountNotFoundException;
import com.osmel.bankingappbackend.services.BankService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankAccoutnController {
    private BankService bankService;

    public BankAccoutnController(BankService bankService) {
        this.bankService = bankService;
    }
    @GetMapping("/accounts/{accountNumber}")

    public BankAccountDto getBankAccountByNumber(@PathVariable String accountNumber) throws AccountNotFoundException {
        return bankService.getBankAccountById(accountNumber);
    }

    @GetMapping("/accounts")
    public  List<BankAccountDto> getBankAccounts() {
        return bankService.getAllAccounts();
    }

    @GetMapping("/accounts/{accountNumber}/operations")
    public List<BankOperationDto> getBankOperations(@PathVariable String accountNumber)  {
        return bankService.getOperationsByAccount(accountNumber);
    }

    @GetMapping("/accounts/{accountNumber}/pageOperations")
    public AccountHistDto getHistory(@PathVariable String accountNumber ,
                                     @RequestParam(name = "page" ,defaultValue = "0") int page ,
                                     @RequestParam(name = "size" , defaultValue = "5") int size) throws AccountNotFoundException {
        return bankService.getAccountHistory(accountNumber,page,size);
    }


}
