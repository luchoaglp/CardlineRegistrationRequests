package com.cardlinesrl.controller;

import com.cardlinesrl.domain.MerchantRequest;
import com.cardlinesrl.domain.Reseller;
import com.cardlinesrl.exception.ResellerNotFoundException;
import com.cardlinesrl.service.MerchantRequestService;
import com.cardlinesrl.service.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class CVController {

    @Autowired
    ResellerService resellerService;

    @Autowired
    MerchantRequestService merchantRequestService;

    @GetMapping("/cv")
    public String home(@RequestParam("reseller") Integer reseller, ModelMap model) throws ResellerNotFoundException {

        Reseller r = resellerService.findByPlataformaId(reseller);

        if(r == null) {
            throw new ResellerNotFoundException("Distribuidor no disponible, pongase en contacto con soporte.");
        }

        MerchantRequest m = new MerchantRequest();

        m.setMerchantRequestDevice("WEB");

        model.addAttribute("reseller", r);
        model.addAttribute("merchantRequest", m);

        return "cv/home";
    }

    @PostMapping("/cv")
    public String createMerchantRequest(@RequestParam("reseller") Integer reseller,
                                        @Valid @ModelAttribute MerchantRequest merchantRequest,
                                        BindingResult bindingResult,
                                        ModelMap model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("reseller", resellerService.findByPlataformaId(reseller));

            return "cv/home";
        }

        merchantRequest.setRequestType("CV");
        merchantRequest.setMerchantRequestCreationDate(new Date());
        merchantRequest.setMerchantRequestNew(true);

        model.addAttribute("reseller", resellerService.findByPlataformaId(reseller));
        model.addAttribute("merchantRequest", merchantRequestService.add(merchantRequest));

        return "cv/success";
    }
}
