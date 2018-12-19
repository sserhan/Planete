package example.domain.planete.bdd;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "planete";
        public static final String COLUMN_NAME_NOM = "nom";
        public static final String COLUMN_NAME_DISTANCE = "distance";
        public static final String COLUMN_NAME_IMAGE = "image";
    }
}