package cn.tuyucheng.taketoday.springai.transcribe;

import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

record TranscriptionRequest(MultipartFile audioFile, @Nullable String context) {
}