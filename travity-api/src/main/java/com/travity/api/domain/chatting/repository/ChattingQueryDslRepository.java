package com.travity.api.domain.chatting.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import com.travity.api.domain.chatting.dto.response.GetAllChatRoomResponse;
import com.travity.api.domain.chatting.dto.response.GetMyChatRoomResponse;
import com.travity.api.domain.chatting.dto.response.GetAllChatMember;
import com.travity.api.domain.chatting.dto.response.GetChatMessageResponse;
import com.travity.api.domain.chatting.entity.QChatMessage;
import com.travity.api.domain.chatting.entity.QChatRoom;
import com.travity.api.domain.chatting.entity.QChatRoomMember;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ChattingQueryDslRepository<T> {

    private final JPAQueryFactory jpaQueryFactory;
    private QChatRoom qChatRoom = QChatRoom.chatRoom;
    private QChatRoomMember qChatRoomMember = QChatRoomMember.chatRoomMember;
    private QChatMessage qChatMessage = QChatMessage.chatMessage;

    // TODO: 페이지네이션 적용 여부 확인
    public List<GetMyChatRoomResponse> findAllMyChatRoom(Long memberId) {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    GetMyChatRoomResponse.class,
                    qChatRoom.id.as("chatRoomId"),
                    qChatRoom.name.as("title")
                )
            ).distinct()
            .from(qChatRoom)
            .join(qChatRoomMember).on(qChatRoom.id.eq(qChatRoomMember.id.chatRoomId))
            .where(
                qChatRoomMember.id.memberId.eq(memberId)
                    .or(qChatRoom.creator.eq(memberId)),
                qChatRoomMember.isExited.eq(false),
                qChatRoom.isDeleted.eq(false)
            )
            .fetch();
    }

    // TODO: userNickname 조인 필요
    public List<GetChatMessageResponse> findAllChatMessage(Long chatRoomId) {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    GetChatMessageResponse.class,
                    qChatMessage.id.as("messageId"),
                    qChatMessage.memberId.as("memberId"),
                    qChatMessage.message.as("message"),
                    qChatMessage.messageType.as("messageType")
                )
            )
            .from(qChatMessage)
            .join(qChatRoom).on(qChatRoom.id.eq(qChatMessage.chatRoomId))
            .where(qChatMessage.isDeleted.eq(false))
            .fetch();
    }

    // TODO: 내가 속한 채팅방도 보여줄 것인지 확인
    public List<GetAllChatRoomResponse> findAllChatRoom() {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    GetAllChatRoomResponse.class,
                    qChatRoom.id.as("chatRoomId"),
                    qChatRoom.name.as("title")
                )
            )
            .from(qChatRoom)
            .where(qChatRoom.isDeleted.eq(false))
            .fetch();
    }

    // TODO: 유저 join 필요
    public List<GetAllChatMember> findAllChatRoomMember(Long chatRoomId) {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    GetAllChatMember.class,
                    qChatRoomMember.id.memberId.as("memberId")
                )
            )
            .from(qChatRoomMember)
            .where(
                qChatRoomMember.id.chatRoomId.eq(chatRoomId),
                qChatRoomMember.isExited.eq(false)
            )
            .fetch();
    }
}