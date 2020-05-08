package com.cardlinesrl.controller;

import com.cardlinesrl.domain.MerchantRequest;
import com.cardlinesrl.domain.Participant;
import com.cardlinesrl.exception.ResellerNotFoundException;
import com.cardlinesrl.service.MerchantRequestService;
import com.cardlinesrl.service.ParticipantService;
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

    //@Autowired
    private final ParticipantService participantService;
    private final MerchantRequestService merchantRequestService;

    public CVController(ParticipantService participantService, MerchantRequestService merchantRequestService) {
        this.participantService = participantService;
        this.merchantRequestService = merchantRequestService;
    }

    @GetMapping("/cv")
    public String home(@RequestParam("reseller") Integer reseller, ModelMap model) throws ResellerNotFoundException {

        Participant r = participantService.findByVirtualId(reseller);

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
    public String createMerchantRequest(@RequestParam("reseller") Integer virtualId,
                                        @Valid @ModelAttribute MerchantRequest merchantRequest,
                                        BindingResult bindingResult,
                                        ModelMap model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("reseller", participantService.findByVirtualId(virtualId));

            return "cv/home";
        }

        merchantRequest.setRequestType("CV");
        merchantRequest.setMerchantRequestCreationDate(new Date());
        merchantRequest.setMerchantRequestNew(true);

        model.addAttribute("reseller", participantService.findByVirtualId(virtualId));
        model.addAttribute("merchantRequest", merchantRequestService.add(merchantRequest));

        return "cv/success";
    }
}
