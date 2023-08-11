package com.app.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

@Controller

public class SubscriberController {
    @Autowired
    private SubscriberRepository repo;
 
    @GetMapping("/")
    @ResponseBody
    public String viewHomePage(Model model) {
      List<Subscriber> listSubscriber = repo.list();
      model.addAttribute("listSubscriber", listSubscriber);
        return "cigar";
    }
    @GetMapping("/new")
    public String showNewForm(Model model) {
        Subscriber subscriber = new Subscriber();
        model.addAttribute("subscriber", subscriber);

        return "subscriber-form";
    }
    @PostMapping("/save")
    public String subscriber(@ModelAttribute("subscriber") Subscriber subscriber) {
    	repo.save(subscriber);
        return "redirect:/";
    }

}
