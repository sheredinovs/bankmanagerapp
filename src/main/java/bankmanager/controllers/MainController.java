package bankmanager.controllers;

import bankmanager.model.client.BankClientImpl;
import bankmanager.model.client.BankClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class MainController {
    @Autowired
    private BankClientRepository bankClientRepository;

    @GetMapping(path="/index")
    public @ResponseBody
    RedirectView addNewClient (@RequestParam String name
                    , @RequestParam String address, @RequestParam Integer age) {
        RedirectView redirectView = new RedirectView("/index.jspx");

        return redirectView;
    }

    @RequestMapping("/")
    public String handler (Model model) {
        return "index";
    }


    @GetMapping(path="/add")
    public @ResponseBody
    String addNewAccount (@RequestParam String name
            , @RequestParam String address, @RequestParam Integer age) {

        BankClientImpl bankClient = new BankClientImpl(name, address, age);
        bankClientRepository.save(bankClient);
        return "Saved";
    }
}