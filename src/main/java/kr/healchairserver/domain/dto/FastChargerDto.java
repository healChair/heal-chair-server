package kr.healchairserver.domain.dto;

import static kr.healchairserver.domain.dto.helper.CollectionHelper.convertNCollect;
import static kr.healchairserver.domain.dto.helper.DtoHelper.noInit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import javax.validation.constraints.NotNull;
import kr.healchairserver.domain.model.FastCharger;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.util.Streamable;

public interface FastChargerDto {

    @With
    @Data
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    class Create {

        @JsonProperty("fcltyNm")
        private String facility;

        @JsonProperty("ctprvnNm")
        private String siDo;

        @JsonProperty("signguNm")
        private String siGnGu;

        @JsonProperty("rdnmadr")
        private String streetNameAddress;

        @JsonProperty("lnmadr")
        private String lotAddress;

        @JsonProperty("latitude")
        private String latitude;

        @JsonProperty("longitude")
        private String longitude;

        @JsonProperty("instlLcDesc")
        private String locationDescription;

        @JsonProperty("weekdayOperOpenHhmm")
        private String weekdayStartTime;

        @JsonProperty("weekdayOperColseHhmm")
        private String weekdayEndTime;

        @JsonProperty("satOperOperOpenHhmm")
        private String saturdayStartTime;

        @JsonProperty("satOperCloseHhmm")
        private String saturdayEndTime;

        @JsonProperty("holidayOperOpenHhmm")
        private String holidayStartTime;

        @JsonProperty("holidayCloseOpenHhmm")
        private String holidayEndTime;

        @JsonProperty("smtmUseCo")
        private String usableNumber;

        @JsonProperty("airInjectorYn")
        private String isAirInjectable;

        @JsonProperty("moblphonChrstnYn")
        private String isPhoneRechargeable;

        @JsonProperty("institutionNm")
        private String managementOrganization;

        @JsonProperty("institutionPhoneNumber")
        private String managementOrganizationPhone;
        public FastCharger asEntity(
            Function<? super FastCharger, ? extends FastCharger> initialize) {
            return initialize.apply(FastCharger.builder()
                .facility(facility)
                .siDo(siDo)
                .siGnGu(siGnGu)
                .streetNameAddress(streetNameAddress)
                .lotAddress(lotAddress)
                .latitude(Doubles.tryParse(latitude))
                .longitude(Doubles.tryParse(longitude))
                .locationDescription(locationDescription)
                .weekdayStartTime(convertToLocalTime(weekdayStartTime))
                .weekdayEndTime(convertToLocalTime(weekdayEndTime))
                .saturdayStartTime(convertToLocalTime(saturdayStartTime))
                .saturdayEndTime(convertToLocalTime(saturdayEndTime))
                .holidayStartTime(convertToLocalTime(holidayStartTime))
                .holidayEndTime(convertToLocalTime(holidayEndTime))
                .usableNumber(Ints.tryParse(usableNumber))
                .isAirInjectable(convertToBoolean(isAirInjectable))
                .isPhoneRechargeable(convertToBoolean(isPhoneRechargeable))
                .managementOrganization(managementOrganization)
                .managementOrganizationPhone(managementOrganizationPhone)
                .build());
        }

        public FastCharger asEntity() {
            return asEntity(noInit());
        }

        private Boolean convertToBoolean(String YOrN) {
            return YOrN.equals("Y");
        }

        private LocalTime convertToLocalTime(String date) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            return LocalTime.parse(date, formatter);
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
