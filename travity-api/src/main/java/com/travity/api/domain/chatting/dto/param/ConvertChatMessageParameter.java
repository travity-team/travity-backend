package com.travity.api.domain.chatting.dto.param;

import com.travity.api.domain.chatting.dto.request.CreateChatMessageRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConvertChatMessageParameter {

    private Long memberId;
    private Long chatRoomId;
    private CreateChatMessageRequest request;
}
