package fr.dosi.etron.controller;


import fr.dosi.etron.service.Impl.ContractServiceImpl;
import fr.dosi.etron.service.ifc.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contrat")
public class ContractController {
    @Autowired
    ContractService contractService;

    @GetMapping
    public void getContract(){};
}
