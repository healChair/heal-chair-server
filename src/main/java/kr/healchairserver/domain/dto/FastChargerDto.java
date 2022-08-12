package kr.healchairserver.domain.dto;

import static kr.healchairserver.domain.dto.helper.CollectionHelper.convertNCollect;
import static kr.healchairserver.domain.dto.helper.DtoHelper.noInit;
import java.time.LocalDateTime;
import java.util.function.Function;
import javax.validation.constraints.NotBlank;
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
                .isAirInjectable(fastCharger.isAirInjectable())
                .isPhoneRechargeable(fastCharger.isPhoneRechargeable())
                .managementOrganization(fastCharger.getManagementOrganization())
                .managementOrganizationPhone(fastCharger.getManagementOrganizationPhone())
                .build();
        }

        public static Page<Result> of(Streamable<FastCharger> fastChargers) {
            return new PageImpl<>(convertNCollect(fastChargers, Result::of));
        }
    }


}
