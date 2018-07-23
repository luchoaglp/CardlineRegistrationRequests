package com.cardlinesrl.controller;

import com.cardlinesrl.domain.MerchantRequest;
import com.cardlinesrl.domain.Reseller;
import com.cardlinesrl.exception.ResellerNotFoundException;
import com.cardlinesrl.service.MerchantRequestService;
import com.cardlinesrl.service.MerchantService;
import com.cardlinesrl.service.ResellerService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
public class SubeController {

    private static final String UPLOADED_FOLDER = "/opt/tomcat8/webapps/request_img/";
    //private static String UPLOADED_FOLDER = "/home/ele/Datos/tomcat/apache-tomcat-7.0.69/webapps/request_img/";

    @Autowired
    ResellerService resellerService;

    @Autowired
    MerchantRequestService merchantRequestService;

    @Autowired
    MerchantService merchantService;

    @GetMapping("/sube")
    public String home(@RequestParam("reseller") Integer reseller, ModelMap model) throws ResellerNotFoundException {

        Reseller r = resellerService.findByPlataformaId(reseller);

        if(r == null) {
            throw new ResellerNotFoundException("Distribuidor no disponible, pongase en contacto con soporte.");
        }

        MerchantRequest m = new MerchantRequest();

        m.setMerchantRequestDevice("WEB");

        model.addAttribute("reseller", r);
        model.addAttribute("merchantRequest", m);

        return "sube/home";
    }

    @PostMapping("/sube")
    public String createMerchantRequest(@RequestParam("merchantRequestFile") MultipartFile file,
                                        @RequestParam("reseller") Integer reseller,
                                        @Valid @ModelAttribute MerchantRequest merchantRequest,
                                        BindingResult bindingResult,
                                        ModelMap model) {

        if(file.getSize() > 2048000) {

            bindingResult.addError(new ObjectError("merchantRequestFile", "La imagen debe ser menor a 2 MB."));
        }

        if (bindingResult.hasErrors()) {

            model.addAttribute("requestFileError", "La imagen debe ser menor a 2 MB!!");
            model.addAttribute("reseller", resellerService.findByPlataformaId(reseller));

            return "sube/home";
        }

        merchantRequest.setRequestType("SUBE");
        merchantRequest.setMerchantRequestCreationDate(new Date());
        merchantRequest.setMerchantRequestNew(true);

        MerchantRequest m = merchantRequestService.add(merchantRequest);

        model.addAttribute("reseller", resellerService.findByPlataformaId(reseller));
        model.addAttribute("merchantRequest", m);

        if(!file.isEmpty()) {

            try {

                byte[] bytes = file.getBytes();

                Path path = Paths.get(UPLOADED_FOLDER + m.getRequestId() + ".jpg");

                Files.write(path, bytes);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return "sube/success";
    }

    @GetMapping("/sube/edit")
    public String homeEdit(@RequestParam("reseller") Integer reseller, ModelMap model) throws Exception {

        Reseller r = resellerService.findByPlataformaId(reseller);

        if(r == null) {
            throw new ResellerNotFoundException("Distribuidor no disponible, pongase en contacto con soporte.");
        }

        MerchantRequest m = new MerchantRequest();

        m.setMerchantRequestDevice("WEB");

        model.addAttribute("reseller", r);
        model.addAttribute("merchantRequest", m);
        model.addAttribute("merchants", merchantService.findByMerchantOwnerId(r.getParticipantId()));

        return "sube/edit/home";
    }

    @PostMapping("/sube/edit")
    public String createMerchantRequestEdit(@RequestParam("merchantRequestFile") MultipartFile file,
                                        @RequestParam("reseller") Integer reseller,
                                        @Valid @ModelAttribute MerchantRequest merchantRequest,
                                        BindingResult bindingResult,
                                        ModelMap model) {

        try {

            if (file.getSize() > 2048000) {

                bindingResult.addError(new ObjectError("merchantRequestFile", "La imagen debe ser menor a 2 MB."));
            }

            if (bindingResult.hasErrors()) {

                model.addAttribute("requestFileError", "La imagen debe ser menor a 2 MB.");
                model.addAttribute("reseller", resellerService.findByPlataformaId(reseller));

                return "/sube/edit/home";
            }

            merchantRequest.setRequestType("SUBE");
            merchantRequest.setMerchantRequestCreationDate(new Date());
            merchantRequest.setMerchantRequestNew(false);

            MerchantRequest m = merchantRequestService.add(merchantRequest);

            model.addAttribute("reseller", resellerService.findByPlataformaId(reseller));
            model.addAttribute("merchantRequest", m);

            if (!file.isEmpty()) {

                try {

                    byte[] bytes = file.getBytes();

                    Path path = Paths.get(UPLOADED_FOLDER + m.getRequestId() + ".jpg");

                    Files.write(path, bytes);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return "/sube/edit/success";

        } catch (ConstraintViolationException e) {

            throw new ConstraintViolationException("El comercio ya tiene una solicitud de alta de Sube.", e.getSQLException(), "");
        }
    }

}
