package com.travity.api.domain.chatting.mapper;

import com.travity.api.domain.chatting.dto.param.ConvertChatMessageParameter;
import com.travity.api.domain.chatting.dto.request.CreateChatRoomRequest;
import com.travity.api.domain.chatting.entity.ChatMessage;
import com.travity.api.domain.chatting.entity.ChatRoom;

import org.springframework.stereotype.Component;

@Component
public class ChattingMapper {

    public ChatRoom createChatRoomRequestToEntity(CreateChatRoomRequest request) {
        return new ChatRoom(request.getChatRoomName(), request.getChatRoomMaker());
    }

    public ChatMessage createChatMessageRequestToEntity(ConvertChatMessageParameter parameter) {
        return ChatMessage.builder()
            .memberId(parameter.getMemberId())
            .chatRoomId(parameter.getChatRoomId())
            .message(parameter.getRequest().getMessage())
            .messageType(parameter.getRequest().getMessageType())
            .build();
    }
}
