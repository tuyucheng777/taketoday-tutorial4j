package cn.tuyucheng.taketoday.quarkus.rbac.api;

public record TokenResponse(String token, String expiresIn) {
}