package cn.tuyucheng.taketoday.imagegen;

record ImageGenerationRequest(
      String prompt,
      String username,
      Integer height,
      Integer width
) {
}