package com.meta.chat.server.domain;

import com.meta.chat.server.domain.user.UserProfile;

public class DomainFactory {

    public static UserProfile getUserProfile(){
        return new UserProfile();
    }

}
