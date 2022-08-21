package kr.healchairserver.domain.dto;

import static kr.healchairserver.domain.dto.helper.CollectionHelper.convertNCollect;
import static kr.healchairserver.domain.dto.helper.DtoHelper.noInit;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import kr.healchairserver.domain.model.FastCharger;
import lombok.Builder;
import lombok.Data;
import lombok.With;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.util.Streamable;

public interface FastChargerDto {

    @With
    @Data
    @Builder
    class Create {

        private String facility;

        private String siDo;

        private String siGnGu;

        private String streetNameAddress;

        private String lotAddress;

        @NotBlank
        private String latitude;

        @NotBlank
        private String longitude;

        private String locationDescription;

        private LocalDateTime weekdayStartTime;

        private LocalDateTime weekdayEndTime;

        private LocalDateTime saturdayStartTime;

        private LocalDateTime saturdayEndTime;

        private LocalDateTime holidayStartTime;

        private LocalDateTime holidayEndTime;

        private int usableNumber;

        private boolean isAirInjectable;

        private boolean isPhoneRechargeable;

        private String managementOrganization;

        private String managementOrganizationPhone;

        public FastCharger asEntity(
            Function<? super FastCharger, ? extends FastCharger> initialize) {
            return initialize.apply(FastCharger.builder()
                .facility(facility)
                .siDo(siDo)
                .siGnGu(siGnGu)
                .streetNameAddress(streetNameAddress)
                .lotAddress(lotAddress)
                .latitude(latitude)
                .longitude(longitude)
                .locationDescription(locationDescription)
                .weekdayStartTime(weekdayStartTime)
                .weekdayEndTime(weekdayEndTime)
                .saturdayStartTime(saturdayStartTime)
                .saturdayEndTime(saturdayEndTime)
                .holidayStartTime(holidayStartTime)
                .holidayEndTime(holidayEndTime)
                .usableNumber(usableNumber)
                .isAirInjectable(isAirInjectable)
                .isPhoneRechargeable(isPhoneRechargeable)
                .managementOrganization(managementOrganization)
                .managementOrganizationPhone(managementOrganizationPhone)
                .build());
        }

        public FastCharger asEntity() {
            return asEntity(noInit());
        }
    }

    @With
    @Data
    @Builder
    class Result {

        private Long id;

        private String facility;

        private String siDo;

        private String siGnGu;

        private String streetNameAddress;

        private String lotAddress;

        @NotNull
        private Double latitude;

        @NotNull
        private Double longitude;

        private String locationDescription;

        private LocalTime weekdayStartTime;

        private LocalTime weekdayEndTime;

        private LocalTime saturdayStartTime;

        private LocalTime saturdayEndTime;

        private LocalTime holidayStartTime;

        private LocalTime holidayEndTime;

        private Integer usableNumber;

        private Boolean isAirInjectable;

        private Boolean isPhoneRechargeable;

        private String managementOrganization;

        private String managementOrganizationPhone;

        public static Result of(FastCharger fastCharger) {
            return Result.builder()
                .id(fastCharger.getId())
                .facility(fastCharger.getFacility())
                .siDo(fastCharger.getSiDo())
                .siGnGu(fastCharger.getSiGnGu())
                .streetNameAddress(fastCharger.getStreetNameAddress())
                .lotAddress(fastCharger.getLotAddress())
                .latitude(fastCharger.getLatitude())
                .longitude(fastCharger.getLongitude())
                .locationDescription(fastCharger.getLocationDescription())
                .weekdayStartTime(fastCharger.getWeekdayStartTime())
                .weekdayEndTime(fastCharger.getWeekdayEndTime())
                .saturdayStartTime(fastCharger.getSaturdayStartTime())
                .saturdayEndTime(fastCharger.getSaturdayEndTime())
                .holidayStartTime(fastCharger.getHolidayStartTime())
                .holidayEndTime(fastCharger.getHolidayEndTime())
                .usableNumber(fastCharger.getUsableNumber())
                .isAirInjectable(fastCharger.getIsAirInjectable())
                .isPhoneRechargeable(fastCharger.getIsPhoneRechargeable())
                .managementOrganization(fastCharger.getManagementOrganization())
                .managementOrganizationPhone(fastCharger.getManagementOrganizationPhone())
                .build();
        }

        public static Page<Result> of(Streamable<FastCharger> fastChargers) {
            return new PageImpl<>(convertNCollect(fastChargers, Result::of));
        }
    }


}
