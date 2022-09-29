package io.github.egd.prodigal.model.domain;

// 将领
public abstract class General extends People implements Warrior {

    private Camp camp;

    public void setPeople(People people) {
        this.setFirstName(people.getFirstName());
        this.setLastName(people.getLastName());
        this.setStyleName(people.getStyleName());
        this.setBirth(people.getBirth());
        this.setDead(people.getDead());
    }

    public abstract void kill(General enemy);

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

}
