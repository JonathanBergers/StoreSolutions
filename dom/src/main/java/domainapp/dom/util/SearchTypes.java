package domainapp.dom.util;

/**
 * Created by jonathan on 30-7-15.
 */
public class SearchTypes {

    public static enum Amount{
        GELIJK_AAN,
        MINDER_DAN,
        MEER_DAN;
    }

    public static enum Text{

        TITEL,
        BESCHRIJVING;
    }

    public static enum Price{
        KOST_PRIJS,
        VERKOOP_PRIJS;
    }
}
