package com.meta.chat.server.command;

import com.alibaba.cola.dto.Response;
import com.meta.chat.server.convertor.UserProfileConvertor;
import com.meta.chat.server.domain.user.UserProfile;
import com.meta.chat.server.dto.UserProfileUpdateCmd;
import com.meta.chat.server.domain.gateway.UserProfileGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserProfileUpdateCmdExe{

    @Resource
    private UserProfileGateway userProfileGateway;

    public Response execute(UserProfileUpdateCmd cmd) {
        UserProfile userProfile = UserProfileConvertor.toEntity(cmd.getUserProfileCO());
        userProfileGateway.update(userProfile);
        return Response.buildSuccess();
    }
}