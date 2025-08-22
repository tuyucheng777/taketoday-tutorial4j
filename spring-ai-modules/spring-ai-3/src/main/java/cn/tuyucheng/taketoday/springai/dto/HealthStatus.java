package cn.tuyucheng.taketoday.springai.dto;

import java.time.LocalDate;

public record HealthStatus(String status, LocalDate changeDate) {
}