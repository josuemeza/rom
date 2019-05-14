package cl.josuemeza.rom.controller;

import cl.josuemeza.rom.repository.CharacterRepository;
import cl.josuemeza.rom.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value="action", produces="application/json")
public class ActionController {

    @Autowired
    private CharacterRepository repository;

    @GetMapping("{attackerId}/attack/{targetId}")
    public ResponseEntity attack(@PathVariable Long attackerId, @PathVariable Long targetId) {
        try {
            Character attacker = repository.findById(attackerId).get();
            Character target = repository.findById(targetId).get();
            Integer damage = attacker.attack(target);
            return new ResponseEntity<Character>(repository.save(target), HttpStatus.OK);
        } catch(NoSuchElementException exception) {
            return new ResponseEntity<String>("{ \"error\": \"Fighter not found\" } ", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("heal/{healValue}/to/{targetId}")
    public ResponseEntity heal(@PathVariable Integer healValue, @PathVariable Long targetId) {
        try {
            Character target = repository.findById(targetId).get();
            target.heal(healValue);
            return new ResponseEntity<Character>(repository.save(target), HttpStatus.OK);
        } catch(NoSuchElementException exception) {
            return new ResponseEntity<String>("{ \"error\": \"Target not found\" } ", HttpStatus.NOT_FOUND);
        }
    }

}
