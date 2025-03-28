package cn.tuyucheng.taketoday.expression.mapper;

import cn.tuyucheng.taketoday.expression.dto.LicenseDto;
import cn.tuyucheng.taketoday.expression.model.License;
import org.mapstruct.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper
public interface LicenseMapper {

   @Mapping(target = "startDate", expression = "java(mapStartDate(licenseDto))")
   @Mapping(target = "endDate", ignore = true)
   @Mapping(target = "active", constant = "true")
   @Mapping(target = "renewalRequired", conditionExpression = "java(isEndDateInTwoWeeks(licenseDto))", source = ".")
   License toLicense(LicenseDto licenseDto);

   @AfterMapping
   default void afterMapping(LicenseDto licenseDto, @MappingTarget License license) {
      OffsetDateTime endDate = licenseDto.getEndDate() != null ? licenseDto.getEndDate()
            .atOffset(ZoneOffset.UTC) : OffsetDateTime.now()
            .plusYears(1);
      license.setEndDate(endDate);
   }

   default OffsetDateTime mapStartDate(LicenseDto licenseDto) {
      return licenseDto.getStartDate() != null ? licenseDto.getStartDate()
            .atOffset(ZoneOffset.UTC) : OffsetDateTime.now();
   }

   default boolean isEndDateInTwoWeeks(LicenseDto licenseDto) {
      return licenseDto.getEndDate() != null && Duration.between(licenseDto.getEndDate(), LocalDateTime.now())
            .toDays() <= 14;
   }

   @Condition
   default boolean mapsToExpectedLicenseType(String licenseType) {
      try {
         if (licenseType == null) return false;
         License.LicenseType.valueOf(licenseType);
         return true;
      } catch (IllegalArgumentException e) {
         return false;
      }
   }
}