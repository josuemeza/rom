package cl.josuemeza.rom.controller;

import cl.josuemeza.rom.repository.CharacterRepository;
import cl.josuemeza.rom.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value="characters", produces="application/json")
public class CharactersController {

    @Autowired
    private CharacterRepository repository;



    @GetMapping("")
    public ResponseEntity index(Pageable pageable) {
        List<Character> characters = repository.findAll(pageable).getContent();
        return new ResponseEntity<List<Character>>(characters, HttpStatus.OK);
    }

    @GetMapping("{characterId}")
    public ResponseEntity show(@PathVariable Long characterId) {
        try {
            Character character = repository.findById(characterId).get();
            return new ResponseEntity<Character>(character, HttpStatus.OK);
        } catch(NoSuchElementException exception) {
            return new ResponseEntity<String>("{ \"error\": \"Not found\" }", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public Character create(@Valid @RequestBody Character character) {
        return repository.save(character);
    }

    @PutMapping("{characterId}")
    public ResponseEntity update(@PathVariable Long characterId, @Valid @RequestBody Character characterRequest) {
        try {
            Character character = repository.findById(characterId).get();
            character.setName(characterRequest.getName());
            return new ResponseEntity<Character>(repository.save(character), HttpStatus.OK);
        } catch(NoSuchElementException exception) {
            return new ResponseEntity<String>("{ \"error\": \"Not found\" } ", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{characterId}")
    public ResponseEntity delete(@PathVariable Long characterId) {
        try {
            Character character = repository.findById(characterId).get();
            repository.delete(character);
            return new ResponseEntity<Character>(character, HttpStatus.OK);
        } catch(NoSuchElementException exception) {
            return new ResponseEntity<String>("{ \"error\": \"Not found\" } ", HttpStatus.NOT_FOUND);
        }
    }

}
