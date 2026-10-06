package com.aaronmull2.finance_tracker.shared;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private static final int SCALE = 4;
    private static final RoundingMode ROUNDING = RoundingMode.HALF_EVEN;

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount.setScale(SCALE, ROUNDING);
    }

    public static Money of(String value) {
        return new Money(new BigDecimal(value));
    }

    public static Money of(BigDecimal value) {
        return new Money(value);
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public Money subtract(Money other) {
        return new Money(this.amount.subtract(other.amount));
    }

    public Money multiply(BigDecimal factor) {
        return new Money(this.amount.multiply(factor).setScale(SCALE, ROUNDING));
    }

    public BigDecimal toBigDecimal() {
        return this.amount;
    }

    @Override
    public String toString() {
        return this.amount.toPlainString();
    }
}
