package io.github.egd.prodigal.model.domain;

import java.util.List;

/**
 * 阵营领域模型
 */
public abstract class Camp {

    /**
     * 主公
     */
    private Lord lord;

    /**
     * 将领
     */
    protected List<General> generals;

    public Lord getLord() {
        return lord;
    }

    public void setLord(Lord lord) {
        this.lord = lord;
    }

    public void setGenerals(List<General> generals) {
        this.generals = generals;
    }

    /**
     * 查看阵营的将领们
     *
     * @return java.util.List
     */
    public abstract List<General> getGenerals();

}
