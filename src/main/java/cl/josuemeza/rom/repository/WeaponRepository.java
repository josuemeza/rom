package cl.josuemeza.rom.repository;

import cl.josuemeza.rom.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

}
