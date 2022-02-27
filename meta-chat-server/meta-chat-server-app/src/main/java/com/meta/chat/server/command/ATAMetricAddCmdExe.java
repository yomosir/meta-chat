package com.meta.chat.server.command;

import com.alibaba.cola.dto.Response;
import com.meta.chat.server.domain.metrics.techinfluence.ATAMetric;
import com.meta.chat.server.domain.metrics.techinfluence.ATAMetricItem;
import com.meta.chat.server.domain.metrics.techinfluence.InfluenceMetric;
import com.meta.chat.server.domain.user.UserProfile;
import com.meta.chat.server.dto.ATAMetricAddCmd;
import com.meta.chat.server.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ATAMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-01 11:42 AM
 */
@Component
public class ATAMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(ATAMetricAddCmd cmd) {
        ATAMetricItem ataMetricItem = new ATAMetricItem();
        BeanUtils.copyProperties(cmd.getAtaMetricCO(), ataMetricItem);
        ataMetricItem.setSubMetric(new ATAMetric(new InfluenceMetric(new UserProfile(cmd.getAtaMetricCO().getOwnerId()))));
        metricGateway.save(ataMetricItem);
        return Response.buildSuccess();
    }
}
