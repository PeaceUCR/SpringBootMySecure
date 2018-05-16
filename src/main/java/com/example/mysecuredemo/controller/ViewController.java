package com.example.mysecuredemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request){
        //https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Referer
        //contains the address of the previous web page from which a link to the currently requested page was followed.
        //sometime not working for firewall
        //https://stackoverflow.com/questions/5536577/how-to-use-request-getheaderreferer
        //this is the simple way to store the url should be redirect to
        String referrer = request.getHeader("Referer");

        System.out.println("view controller");
        System.out.println(referrer);

        if(referrer!=null){
            request.getSession().setAttribute("url_prior_login", referrer);
        }
        return "login";
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "home";
    }
}
