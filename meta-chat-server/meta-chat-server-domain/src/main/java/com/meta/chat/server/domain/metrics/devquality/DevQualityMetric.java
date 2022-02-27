package com.meta.chat.server.domain.metrics.devquality;

import com.meta.chat.server.domain.metrics.MainMetric;
import com.meta.chat.server.domain.metrics.MainMetricType;
import com.meta.chat.server.domain.user.UserProfile;
import lombok.Data;

@Data
public class DevQualityMetric extends MainMetric {

    private BugMetric bugMetric;

    public DevQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setDevQualityMetric(this);
        this.metricMainType = MainMetricType.DEV_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getDevQualityWeight();
    }
}
