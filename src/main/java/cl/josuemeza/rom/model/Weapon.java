package cl.josuemeza.rom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Weapon extends Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer attackBonus;

    public Weapon(String name, String description, Integer attackBonus) {
        super(name, description);
        this.attackBonus = attackBonus;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Integer getAttackBonus() {
        return attackBonus;
    }
}
