package org.strokova.gamestore.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.strokova.gamestore.service.ApplicationServiceImpl;

/**
 * @author vstrokova, 12.09.2016.
 */
@Controller
@RequestMapping("/upload")
public class UploadApplicationController {

    @Autowired
    private ApplicationServiceImpl applicationService;

    @RequestMapping(method = GET)
    public String showUploadApplicationPage() {
        return "upload";
    }

    @RequestMapping(method = POST)
    public String uploadApplication(
            @RequestParam String userGivenName,
            @RequestParam String description,
            @RequestPart("applicationFile") MultipartFile file) {
        applicationService.saveUploadedApplication(userGivenName, description, file);
        return "upload"; // TODO: redirect
    }
}