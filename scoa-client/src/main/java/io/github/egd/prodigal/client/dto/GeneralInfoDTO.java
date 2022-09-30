package io.github.egd.prodigal.client.dto;

/**
 * 将领信息
 */
public class GeneralInfoDTO {

    /**
     * 姓名
     */
    private String name;

    /**
     * 生卒年
     */
    private String birthAndDead;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthAndDead() {
        return birthAndDead;
    }

    public void setBirthAndDead(String birthAndDead) {
        this.birthAndDead = birthAndDead;
    }
}
