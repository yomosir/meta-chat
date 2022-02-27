package com.meta.chat.server.command;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.Assert;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.meta.chat.server.domain.metrics.SubMetric;
import com.meta.chat.server.domain.metrics.appquality.AppMetric;
import com.meta.chat.server.domain.metrics.appquality.AppQualityMetric;
import com.meta.chat.server.domain.metrics.devquality.BugMetric;
import com.meta.chat.server.domain.metrics.devquality.DevQualityMetric;
import com.meta.chat.server.domain.metrics.techcontribution.ContributionMetric;
import com.meta.chat.server.domain.metrics.techinfluence.InfluenceMetric;
import com.meta.chat.server.domain.user.UserProfile;
import com.meta.chat.server.dto.RefreshScoreCmd;
import com.meta.chat.server.event.handler.MetricItemCreatedHandler;
import com.meta.chat.server.domain.gateway.MetricGateway;
import com.meta.chat.server.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class RefreshScoreCmdExe{
    private Logger logger = LoggerFactory.getLogger(MetricItemCreatedHandler.class);

    @Resource
    private UserProfileGateway userProfileGateway;

    @Resource
    private MetricGateway metricGateway;

    public Response execute(RefreshScoreCmd cmd) {
        UserProfile userProfile = getUserProfile(cmd);
        calculateScore(userProfile);
        update(userProfile);
        return Response.buildSuccess();
    }

    private UserProfile getUserProfile(RefreshScoreCmd cmd) {
        UserProfile userProfile = userProfileGateway.getByUserId(cmd.getUserId());
        Assert.notNull(userProfile, "There is no User Profile for "+cmd.getUserId()+" to update");
        return userProfile;
    }

    private void calculateScore(UserProfile userProfile) {
        loadInfluenceMetric(userProfile);
        loadContributionMetrics(userProfile);
        loadDevQualityMetrics(userProfile);
        loadAppQualityMetrics(userProfile);
        userProfile.calculateScore();
    }

    private void loadAppQualityMetrics(UserProfile userProfile) {
        AppQualityMetric appQualityMetric = new AppQualityMetric(userProfile);
        AppMetric appMetric = metricGateway.getAppMetric(userProfile.getUserId());
        appMetric.setParent(appQualityMetric);
    }

    private void loadDevQualityMetrics(UserProfile userProfile) {
        DevQualityMetric devQualityMetric = new DevQualityMetric(userProfile);
        BugMetric bugMetric = metricGateway.getBugMetric(userProfile.getUserId());
        bugMetric.setParent(devQualityMetric);
    }

    private void loadContributionMetrics(UserProfile userProfile) {
        ContributionMetric contributionMetric = new ContributionMetric(userProfile);
        List<SubMetric> subMetricList = metricGateway.listByTechContribution(userProfile.getUserId());
        subMetricList.forEach(subMetric -> subMetric.setParent(contributionMetric));
    }

    private void loadInfluenceMetric(UserProfile userProfile) {
        InfluenceMetric influenceMetric = new InfluenceMetric(userProfile);
        List<SubMetric> subMetricList = metricGateway.listByTechInfluence(userProfile.getUserId());
        subMetricList.forEach(subMetric -> subMetric.setParent(influenceMetric));
    }

    private void update(UserProfile userProfile) {
        userProfileGateway.update(userProfile);
    }
}
