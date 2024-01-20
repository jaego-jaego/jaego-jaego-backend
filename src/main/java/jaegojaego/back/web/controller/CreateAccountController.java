package jaegojaego.back.web.controller;

import jaegojaego.back.web.entity.CreateAccount;
import jaegojaego.back.web.service.CreateAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/CreateAccount")
public class CreateAccountController {
    private final CreateAccountService createAccountService;

    public CreateAccountController(CreateAccountService createAccountService) {
        this.createAccountService = createAccountService;
    }


    @PostMapping("/createAccount")
    public String insertAccount(@RequestParam String businessNumber,
                                @RequestParam String businessName,
                                @RequestParam LocalDate openDate,
                                @RequestParam String shopName,
                                @RequestParam(defaultValue = "") String shopAdress,
                                @RequestParam String email,
                                @RequestParam(defaultValue = "") String phoneNumber,
                                @RequestParam String id,
                                @RequestParam String pw){
        CreateAccount createAccount = new CreateAccount();

        createAccount.setBusinessNumber(businessNumber);
        createAccount.setBusinessname(businessName);
        createAccount.setOpenDate(openDate);
        createAccount.setShopName(shopName);
        createAccount.setShopAdress(shopAdress);
        createAccount.setEmail(email);
        createAccount.setPhoneNumber(phoneNumber);
        createAccount.setId(id);
        createAccount.setPw(pw);

        createAccountService.insertAccount(createAccount);

        return "/login";
    }
}
