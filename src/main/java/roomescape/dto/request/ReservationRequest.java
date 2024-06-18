package roomescape.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ReservationRequest {

    @NotBlank(message = "예약자명은 필수 값입니다.")
    private String name;

    @NotBlank(message = "날짜는 필수 값입니다.")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "yyyy-MM-dd 형식이 아닙니다.")
    private String date;

    @NotBlank(message = "예약하려면 시간을 선택해야합니다. 확인 후 다시 시도해주세요.")
    private String timeId;

    @NotBlank(message = "예약하려면 테마를 선택해야합니다. 확인 후 다시 시도해주세요.")
    private String themeId;

    public ReservationRequest() {
    }

    public ReservationRequest(String name, String date, String timeId, String themeId) {
        this.name = name;
        this.date = date;
        this.timeId = timeId;
        this.themeId = themeId;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTimeId() {
        return timeId;
    }

    public String getThemeId() {
        return themeId;
    }
}