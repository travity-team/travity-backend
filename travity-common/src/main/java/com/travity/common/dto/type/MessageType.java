package com.travity.common.dto.type;

public enum MessageType {
    N("NOTIFICATION_TYPE"),
    M("MESSAGE_TYPE");

    String type;

    MessageType(String type) {
        this.type = type;
    }
}
