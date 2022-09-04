package com.bank.credit.bankcredit.controller;

import com.bank.credit.bankcredit.domain.Client;
import com.bank.credit.bankcredit.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {

    ClientService clientService;

    @GetMapping
    public Page<Client> getClients(Pageable pageable) {
        return clientService.getClients(pageable);
    }

    @GetMapping("{id}")
    public Client getClient(@PathVariable("id") Long id) {
        return clientService.getClient(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    //@IsAdmin
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("{id}")
    //@IsAdmin
    public Client updateClient(@PathVariable("id") Long id, @Valid @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClient(id);
    }

}
