package cl.josuemeza.rom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.josuemeza.rom.model.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
