package cl.josuemeza.rom.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Equipment extends BaseModel {

    private String name;
    private String description;

    public Equipment(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAttackBonus() {
        return 0;
    }

    public Integer getDefenseBonus() {
        return 0;
    }

}
