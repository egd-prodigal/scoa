package io.github.egd.prodigal.model.domain;

/**
 * 战士，战争参与者，此处定义战士的行为
 */
public interface Warrior {

    /**
     * 杀敌方将领
     *
     * @param enemy 地方将领
     */
    void kill(General enemy);

    /**
     * 战术于两军阵前垃圾话环节
     *
     * @param words 话语
     */
    default void speak(String words) {
        System.out.println(words);
    }

}
