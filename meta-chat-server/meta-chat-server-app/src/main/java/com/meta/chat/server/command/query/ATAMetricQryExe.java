package com.meta.chat.server.command.query;

import com.alibaba.cola.dto.MultiResponse;
import com.meta.chat.server.domain.metrics.SubMetricType;
import com.meta.chat.server.dto.ATAMetricQry;
import com.meta.chat.server.dto.clientobject.ATAMetricCO;
import com.meta.chat.server.gatewayimpl.database.MetricMapper;
import com.meta.chat.server.gatewayimpl.database.dataobject.MetricDO;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class ATAMetricQryExe{

    @Resource
    private MetricMapper metricMapper;

    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        List<MetricDO> metricDOList = metricMapper.listBySubMetric(cmd.getOwnerId(), SubMetricType.ATA.getMetricSubTypeCode());
        List<ATAMetricCO> ataMetricCOList = new ArrayList<>();
        metricDOList.forEach(metricDO -> {
            ATAMetricCO ataMetricCO = JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
            ataMetricCO.setOwnerId(metricDO.getUserId());
            ataMetricCOList.add(ataMetricCO);
        });
        return MultiResponse.ofWithoutTotal(ataMetricCOList);
    }

}
