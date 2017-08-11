package me.aoa4eva.nifbdemo.controllers;

import me.aoa4eva.nifbdemo.FizzBuzzRepository;
import me.aoa4eva.nifbdemo.models.FizzBuzz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    FizzBuzzRepository fizzBuzzRepository;
    @GetMapping("/")
    public String showIndex(@ModelAttribute("fizzBuzzObj") FizzBuzz fizzBuzzObj)
    {


        return "index";
    }

    @PostMapping("/")
    public String showResult(@Valid @ModelAttribute("fizzBuzzObj") FizzBuzz fizzBuzzObj, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "index";
        }
        fizzBuzzRepository.save(fizzBuzzObj);
        ArrayList<String> fBResults = fizzBuzzObj.runFizzBuzz();

        for(String item:fBResults)
        {
            System.out.println(item);
        }

        model.addAttribute("fBR",fBResults);
        return "fizzbuzzresult";
    }
    @GetMapping("/showPlayers")
    public String showIndex(Model model)
    {

        model.addAttribute("userList",fizzBuzzRepository.findAll());
        return "listusers";
    }
}
