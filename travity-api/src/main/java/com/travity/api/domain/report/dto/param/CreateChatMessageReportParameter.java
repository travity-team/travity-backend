package com.travity.api.domain.report.dto.param;

import com.travity.api.domain.report.dto.request.CreateReportRequest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateChatMessageReportParameter {

    private CreateReportRequest reportRequest;
    private Long chatRoomId;
    private Long messageId;
    private Long reporterId;
}
