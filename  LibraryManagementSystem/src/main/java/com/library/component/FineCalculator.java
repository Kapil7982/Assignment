package com.library.component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

@Component
public class FineCalculator {

	public static final double FINE_PER_DAY = 1.0;

    public static double calculateFine(LocalDate dueDate, LocalDate returnDate) {
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        if (daysLate <= 0) {
            return 0.0;
        }
        return daysLate * FINE_PER_DAY;
    }
}
