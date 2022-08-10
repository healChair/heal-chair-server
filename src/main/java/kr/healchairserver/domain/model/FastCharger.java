package kr.healchairserver.domain.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.With;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
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

    @Builder
    private FastCharger(String facility, String siDo, String siGnGu, String streetNameAddress,
        String lotAddress, String latitude, String longitude, String locationDescription,
        LocalDateTime weekdayStartTime, LocalDateTime weekdayEndTime,
        LocalDateTime saturdayStartTime,
        LocalDateTime saturdayEndTime, LocalDateTime holidayStartTime, LocalDateTime holidayEndTime,
        int usableNumber, boolean isAirInjectable, boolean isPhoneRechargeable,
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
