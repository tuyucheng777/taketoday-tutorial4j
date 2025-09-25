package cn.tuyucheng.taketoday.springai.streaming;

import javax.validation.constraints.NotNull;

public class ChatRequest {

   @NotNull
   private String prompt;

   public String getPrompt() {
      return prompt;
   }

   public void setPrompt(String prompt) {
      this.prompt = prompt;
   }
}