package com.cardlinesrl.controller;

import com.cardlinesrl.domain.Merchant;
import com.cardlinesrl.service.MerchantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MerchantController {

    //@Autowired
    //MerchantService merchantService;

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @RequestMapping(value = "/merchants/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> getMerchantByPlataformaId(
            @PathVariable("id") int virtualId) {

        Merchant merchant = merchantService.findByVirtualId(virtualId);

        if (merchant == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(merchant, HttpStatus.OK);
    }

}
