package it.unibo.nestedenum;

import java.time.Month;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    public enum Month{
        JANUARY("january", 31),
        FEBRUARY("february", 28),
        MARCH("march", 31),
        APRIL("april", 30),
        MAY("may", 31),
        JUNE("june", 30),
        JULY("july", 31),
        AUGUST("august", 31),
        SEPTEMBER("september", 30),
        OCTOBER("october", 31),
        NOVEMBER("november", 30),
        DECEMBER("december", 31);

        private final String actualName;
        private final int days;

        private Month(final String actualName, final int days){
            this.actualName = actualName;
            this.days = days;
        }

        public String getActualName() {
            return actualName;
        }

        public int getDays() {
            return days;
        }

        Month fromString(String namePiece){
            for(final Month month : Month.values()){
                if (month.equals(namePiece)){
                    return month;
                }
            }

            return null;
        }

        boolean equals(final String month){
            return getActualName().equalsIgnoreCase(month);
        }
    }
}
