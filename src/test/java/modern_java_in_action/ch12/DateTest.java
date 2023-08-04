package modern_java_in_action.ch12;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;

import org.jetbrains.kotlin.com.google.gson.internal.$Gson$Preconditions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateTest {

	@DisplayName("duration 은 두 시간 사이의 간격을 나타낼 때 사용한다.")
	@Test
	void durationTest() {
		LocalTime lunchStartTime = LocalTime.of(11, 30);
		LocalTime lunchEndTime = lunchStartTime.plusHours(1).plusMinutes(30);

		Duration duration = Duration.between(lunchStartTime, lunchEndTime);

		assertThat(duration.toMinutes()).isEqualTo(90);
		assertThat(duration.toString()).isEqualTo("1H30M");
	}

	@DisplayName("period 은 두 날짜 사이의 간격을 나타낼 때 사용한다.")
	@Test
	void periodTest() {
		LocalDate holidayStartDate = LocalDate.now();
		LocalDate holidayEndDate = holidayStartDate.plusWeeks(3);

		Period period = Period.between(holidayStartDate, holidayEndDate);

		assertThat(period.getDays()).isEqualTo(21);
		assertThat(period.toString()).isEqualTo("P21D");
	}
}
