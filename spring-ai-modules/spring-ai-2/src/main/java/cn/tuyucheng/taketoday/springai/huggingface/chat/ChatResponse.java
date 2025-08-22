package cn.tuyucheng.taketoday.springai.huggingface.chat;

import java.util.UUID;

public record ChatResponse(UUID chatId, String answer) {
}