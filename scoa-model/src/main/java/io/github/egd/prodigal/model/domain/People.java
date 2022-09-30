package io.github.egd.prodigal.model.domain;

/**
 * 人的领域模型，暂定几个属性
 */
public abstract class People {

    /**
     * 生卒年不详，用这个表示
     */
    public static final String BIRTH_DEAD_NOT_RECORD = "Not Record";

    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;

    /**
     * 字
     */
    private String styleName;

    /**
     * 生于
     */
    private String birth;

    /**
     * 卒于
     */
    private String dead;

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }
}
