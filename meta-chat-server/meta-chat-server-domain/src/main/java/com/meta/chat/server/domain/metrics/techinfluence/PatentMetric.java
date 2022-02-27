package com.meta.chat.server.domain.metrics.techinfluence;

import com.meta.chat.server.domain.metrics.*;

/**
 * 技术专利指标
 * @author xueliang.sxl
 */
public class PatentMetric extends SubMetric {

    public PatentMetric(){
        this.subMetricType = SubMetricType.Patent;
    }

    public PatentMetric(MainMetric parent) {
        this.parent = parent;
        parent.addSubMetric(this);
        this.subMetricType = SubMetricType.Patent;
    }

    @Override
    public double getWeight() {
        return parent.getMetricOwner().getWeight().getUnanimousWeight();
    }
}
