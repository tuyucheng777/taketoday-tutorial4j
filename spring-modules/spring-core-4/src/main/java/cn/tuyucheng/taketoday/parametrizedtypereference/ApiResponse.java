package cn.tuyucheng.taketoday.parametrizedtypereference;

public record ApiResponse<T>(boolean success, String message, T data) {
}