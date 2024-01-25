package business;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import it.unibs.se_project.business.Period;

public class PeriodTest {

    @Test
    public void testGetMenuTematici() {
        Period[] periods = {
            Period.fromString("20-01|31-12"),
            Period.fromString("10-08|24-08"),
            Period.fromString("20-08|23-08"),
            Period.fromString("12-12|30-12")
        };

        LocalDate sampleDate = LocalDate.of(2023, 8, 24);
        assertEquals(true, Period.dateIncludedInPeriod(sampleDate, periods[0]));
        assertEquals(true, Period.dateIncludedInPeriod(sampleDate, periods[1]));
        assertEquals(false, Period.dateIncludedInPeriod(sampleDate, periods[2]));
        assertEquals(false, Period.dateIncludedInPeriod(sampleDate, periods[3]));
    }
}
