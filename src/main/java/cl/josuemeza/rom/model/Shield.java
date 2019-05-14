package cl.josuemeza.rom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shield extends Equipment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Integer defenseBonus;

    public Shield(String name, String description, Integer defenseBonus) {
        super(name, description);
        this.defenseBonus = defenseBonus;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Integer getDefenseBonus() {
        return defenseBonus;
    }
}
