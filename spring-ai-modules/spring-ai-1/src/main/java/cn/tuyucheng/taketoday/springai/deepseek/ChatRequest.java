package cn.tuyucheng.taketoday.springai.deepseek;

import org.springframework.lang.Nullable;

import java.util.UUID;

record ChatRequest(@Nullable UUID chatId, String question) {
}