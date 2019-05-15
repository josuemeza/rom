package cl.josuemeza.rom.controller;

import cl.josuemeza.rom.model.Character;
import cl.josuemeza.rom.service.BattleService;
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
    private BattleService battleService;

    @GetMapping("{attackerId}/attack/{targetId}")
    public ResponseEntity attack(@PathVariable Long attackerId, @PathVariable Long targetId) {
        return getResponseEntity(battleService.attack(attackerId, targetId), "{ \"error\": \"Fighter not found\" } ");
    }

    @GetMapping("heal/{healValue}/to/{targetId}")
    public ResponseEntity heal(@PathVariable Integer healValue, @PathVariable Long targetId) {
        return getResponseEntity(battleService.heal(targetId, healValue), "{ \"error\": \"Target not found\" } ");
    }

    private ResponseEntity getResponseEntity(Character character, String errorMessage) {
        try {
            return new ResponseEntity<Character>(character, HttpStatus.OK);
        } catch (NoSuchElementException exception) {
            return new ResponseEntity<String>(errorMessage, HttpStatus.NOT_FOUND);
        }
    }

}
