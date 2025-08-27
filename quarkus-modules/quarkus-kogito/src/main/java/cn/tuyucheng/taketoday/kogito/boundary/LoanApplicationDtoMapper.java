package cn.tuyucheng.taketoday.kogito.boundary;

import org.mapstruct.Mapper;

import cn.tuyucheng.taketoday.kogito.boundary.model.LoanApplicationDto;
import cn.tuyucheng.taketoday.kogito.rules.model.LoanApplication;

@Mapper(componentModel = "cdi")
public interface LoanApplicationDtoMapper {

   LoanApplication map(LoanApplicationDto loanApplicationDto);

   LoanApplicationDto map(LoanApplication loanApplication);
}