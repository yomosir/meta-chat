package com.meta.chat.server.domain.metrics.appquality;

import com.meta.chat.server.domain.metrics.MainMetric;
import com.meta.chat.server.domain.metrics.MainMetricType;
import com.meta.chat.server.domain.metrics.devquality.BugMetric;
import com.meta.chat.server.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
