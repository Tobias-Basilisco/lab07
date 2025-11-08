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
        return new ByOrderComparator();
    }

    private static final class ByOrderComparator implements Comparator<String> {
    @Override
    public int compare(final String s1, final String s2) {
        final Month m1 = Month.JANUARY.fromString(s1);
        final Month m2 = Month.JANUARY.fromString(s2);
        return Integer.compare(m1.ordinal(), m2.ordinal());
    }
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
            if (namePiece == null || namePiece.isEmpty()) {
                throw new IllegalArgumentException("Month name cannot be null or empty.");
            }

            final String lowerPiece = namePiece.toLowerCase();
            Month found = null; 
            
            for(final Month month : Month.values()){
                if (month.actualName.startsWith(lowerPiece)){
                    if (found != null){
                        throw new IllegalArgumentException("Ambiguous month string input: " + namePiece);
                    }
                    found = month;
                }
            }

            if (found == null) {
                throw new IllegalArgumentException("No month found for: " + namePiece);
            }

            return found;
        }

        boolean equals(final String month){
            return getActualName().equalsIgnoreCase(month);
        }
    }
}
