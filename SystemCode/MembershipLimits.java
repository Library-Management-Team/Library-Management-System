package SystemCode;

import java.math.BigDecimal;

public final class MembershipLimits {

    public static final int STANDARD_ITEM_LIMIT = 5;
    public static final int PREMIUM_ITEM_LIMIT = 10;
    public static final int STANDARD_LOAN_PERIOD = 0;
    public static final int PREMIUM_LOAN_PERIOD = 7;
    public static final BigDecimal MAX_OUTSTANDING_FINE = new BigDecimal("10.00");

    private MembershipLimits() {

    }
}
