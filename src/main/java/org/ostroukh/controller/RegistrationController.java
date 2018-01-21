package org.ostroukh.controller;

import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.entity.enums.UserRole;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @Autowired
    CredentialService credentialService;

    @Autowired
    ShaPasswordEncoder shaPasswordEncoder;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration(Model model){
        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        Credential credential = user.getCredential();
        credential.setRole(UserRole.ROLE_CUSTOMER);

        String password =  shaPasswordEncoder.encodePassword(credential.getPassword(), null);
        credential.setPassword(password);

        credentialService.saveCredential(credential);
        userService.saveUser(user);

        //securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/registration_success";
    }

    @RequestMapping(value = "/registration_success", method = RequestMethod.GET)
    public String registrationSuccess(Model model) {
        return "registration_success";
    }


}
