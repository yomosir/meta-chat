package com.meta.chat.server.command;

import com.alibaba.cola.dto.Response;
import com.meta.chat.server.domain.metrics.techcontribution.ContributionMetric;
import com.meta.chat.server.domain.metrics.techcontribution.RefactoringLevel;
import com.meta.chat.server.domain.metrics.techcontribution.RefactoringMetric;
import com.meta.chat.server.domain.metrics.techcontribution.RefactoringMetricItem;
import com.meta.chat.server.domain.user.UserProfile;
import com.meta.chat.server.dto.RefactoringMetricAddCmd;
import com.meta.chat.server.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * RefactoringMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-04 11:15 AM
 */
@Component
public class RefactoringMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(RefactoringMetricAddCmd cmd) {
        RefactoringMetricItem refactoringMetricItem = new RefactoringMetricItem();
        BeanUtils.copyProperties(cmd.getRefactoringMetricCO(), refactoringMetricItem);
        refactoringMetricItem.setSubMetric(new RefactoringMetric(new ContributionMetric(new UserProfile(cmd.getRefactoringMetricCO().getOwnerId()))));
        refactoringMetricItem.setRefactoringLevel(RefactoringLevel.valueOf(cmd.getRefactoringMetricCO().getRefactoringLevel()));
        metricGateway.save(refactoringMetricItem);
        return Response.buildSuccess();
    }
}
