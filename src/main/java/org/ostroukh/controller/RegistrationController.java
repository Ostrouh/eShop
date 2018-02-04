package org.ostroukh.controller;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.entity.enums.UserRole;
import org.ostroukh.model.service.CartService;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"cart"})
@Controller
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    UserService userService;

    @Autowired
    CredentialService credentialService;

    @Autowired
    CartService cartService;

    @Autowired
    ShaPasswordEncoder shaPasswordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @ModelAttribute("cart")
    public Cart cartInit(){
        return new Cart();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistration(Model model){
        model.addAttribute("user", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, @ModelAttribute("cart") Cart cart, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        Credential credential = user.getCredential();
        credential.setRole(UserRole.ROLE_CUSTOMER);

        String password = credential.getPassword();
        String encodedPassword = shaPasswordEncoder.encodePassword(password, null);

        credential.setPassword(encodedPassword);

        credentialService.saveCredential(credential);
        userService.saveUser(user);

        autoLogin(credential.getLogin(), password);

        return "redirect:/registration_success";
    }

    @RequestMapping(value = "/registration_success", method = RequestMethod.GET)
    public String registrationSuccess() {
        return "registration_success";
    }

    /**
     * Adding just registered user to Security Context
     * @param login
     * @param password
     */
    private void autoLogin(String login, String password){
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);

        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (BadCredentialsException e){
        }

    }

}
