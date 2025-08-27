package cn.tuyucheng.taketoday.kogito.boundary.model;

import jakarta.validation.constraints.NotNull;

public record LoanApplicationsInputDto(@NotNull LoanApplicationDto[] applications) {
}