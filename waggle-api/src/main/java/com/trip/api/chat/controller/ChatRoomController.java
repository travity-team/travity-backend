package com.trip.api.chat.controller;

import com.trip.api.chat.dto.request.CreateChatRoomRequest;
import com.trip.api.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/chat")
@RequiredArgsConstructor
@RestController
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping
    public ResponseEntity<Void> createChatRoom(@RequestBody CreateChatRoomRequest chatRoomRequest) {
        Long chatRoomId = chatRoomService.createChatRoom(chatRoomRequest);
        return ResponseEntity.created(URI.create("/chat/" + chatRoomId)).build();
    }

    @DeleteMapping("/{chatRoomId}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable Long chatRoomId) {
        chatRoomService.deleteChatRoom(chatRoomId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/exit-room/{chatRoomId}")
    public ResponseEntity<Void> exitChatRoom(@PathVariable Long chatRoomId) {
        // TODO: get userId from jwt
        chatRoomService.exitChatRoom(chatRoomId, 71L);
        return ResponseEntity.ok().build();
    }
}
