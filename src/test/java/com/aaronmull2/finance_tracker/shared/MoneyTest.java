package com.aaronmull2.finance_tracker.shared;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTest {
    @Test
    void add_two_amounts_returns_correct_sum() {
        Money a = Money.of("10.00");
        Money b = Money.of("5.00");

        Money result = a.add(b);

        assertEquals("15.0000", result.toString());
    }

    @Test
    void subtract_two_amounts_returns_correct_difference() {
        Money a = Money.of("10.00");
        Money b = Money.of("3.00");

        Money result = a.subtract(b);

        assertEquals("7.0000", result.toString());
    }

    @Test
    void multiply_by_factor_returns_correct_result() {
        Money a = Money.of("10.00");

        Money result = a.multiply(new BigDecimal("0.2"));

        assertEquals("2.0000", result.toString());
    }

    @Test
    void of_floating_point_string_stores_exact_value() {
        Money a = Money.of("0.10");
        Money b = Money.of("0.20");

        Money result = a.add(b);

        assertEquals("0.3000", result.toString());
}

}

