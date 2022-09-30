package io.github.egd.prodigal.model.domain;

/**
 * 将领领域模型
 */
public abstract class General extends People implements Warrior {

    /**
     * 所属阵营
     */
    private Camp camp;

    /**
     * 初始化将领，设置当前将领是谁
     *
     * @param people 人物
     */
    public void setPeople(People people) {
        this.setFirstName(people.getFirstName());
        this.setLastName(people.getLastName());
        this.setStyleName(people.getStyleName());
        this.setBirth(people.getBirth());
        this.setDead(people.getDead());
    }

    /**
     * 杀敌方将领
     *
     * @param enemy 地方将领
     */
    public abstract void kill(General enemy);

    public Camp getCamp() {
        return camp;
    }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }

}
