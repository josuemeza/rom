package cl.josuemeza.rom.service;

import cl.josuemeza.rom.model.Character;
import cl.josuemeza.rom.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BattleService {

    @Autowired
    private CharacterRepository repository;

    public Character attack(Long attackerId, Long targetId) {
        Character attacker = repository.findById(attackerId).get();
        Character target = repository.findById(targetId).get();

        target.defend(attacker.getAttack());
        return repository.save(target);
    }

    public Character heal(Long targetId, Integer healValue) {
        Character target = repository.findById(targetId).get();
        target.heal(healValue);
        return repository.save(target);
    }
}
