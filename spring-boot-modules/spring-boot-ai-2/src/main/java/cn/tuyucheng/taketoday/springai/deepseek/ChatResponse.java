package cn.tuyucheng.taketoday.springai.deepseek;

import java.util.UUID;

record ChatResponse(UUID chatId, String chainOfThought, String answer) {
}