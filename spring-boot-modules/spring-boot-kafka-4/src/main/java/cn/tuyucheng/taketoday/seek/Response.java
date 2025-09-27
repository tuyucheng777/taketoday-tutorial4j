package cn.tuyucheng.taketoday.seek;

public record Response(int partition, long offset, String value) {
}