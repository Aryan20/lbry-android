package com.aryan.lbrybrowser.model.lbryinc;

import lombok.Data;

@Data
public class Invitee {
    private boolean header;
    private String email;
    private boolean inviteRewardClaimed;
    private boolean inviteRewardClaimable;
}
