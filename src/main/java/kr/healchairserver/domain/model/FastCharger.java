package kr.healchairserver.domain.model;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@With
@ToString
@Entity
public class FastCharger extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String facility;

    private String siDo;

    private String siGnGu;

    private String streetNameAddress;

    private String lotAddress;

    private Double latitude;

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

    @Builder
    private FastCharger(String facility, String siDo, String siGnGu, String streetNameAddress,
        String lotAddress, Double latitude, Double longitude, String locationDescription,
        LocalTime weekdayStartTime, LocalTime weekdayEndTime,
        LocalTime saturdayStartTime,
        LocalTime saturdayEndTime, LocalTime holidayStartTime, LocalTime holidayEndTime,
        Integer usableNumber, Boolean isAirInjectable, Boolean isPhoneRechargeable,
        String managementOrganization, String managementOrganizationPhone) {
        this.facility = facility;
        this.siDo = siDo;
        this.siGnGu = siGnGu;
        this.streetNameAddress = streetNameAddress;
        this.lotAddress = lotAddress;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDescription = locationDescription;
        this.weekdayStartTime = weekdayStartTime;
        this.weekdayEndTime = weekdayEndTime;
        this.saturdayStartTime = saturdayStartTime;
        this.saturdayEndTime = saturdayEndTime;
        this.holidayStartTime = holidayStartTime;
        this.holidayEndTime = holidayEndTime;
        this.usableNumber = usableNumber;
        this.isAirInjectable = isAirInjectable;
        this.isPhoneRechargeable = isPhoneRechargeable;
        this.managementOrganization = managementOrganization;
        this.managementOrganizationPhone = managementOrganizationPhone;
    }
}
