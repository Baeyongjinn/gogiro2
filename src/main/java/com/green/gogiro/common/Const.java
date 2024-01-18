package com.green.gogiro.common;

public class Const {
    public static final int SUCCESS = 1;
    public static final int FAIL = 0;

    public static final int ON = 1;
    public static final int OFF = 0;

    public static final int ID_NULL = 3;
    public static final int PW_FAIL = 2;

    public static final int PIC_MAX = 5;

    public static final String REGEXP_PATTERN_SPACE_CHAR = "^[\\s]*$";

    public static final String REGEXP_PATTERN_SPACE_CHAR_TYPE_2 = "^([ ][\\s]*)$";

    public static final String REGEXP_USER_ID = "^[a-zA-Z0-9_-]+@([a-zA-Z0-9]{3,}\\.[a-z]{2,}|[a-zA-Z0-9]{3,}\\.[a-z]{2,}\\.[a-z]{2,})$";

    public static final String REGEXP_USER_TEL = "^01[0-1|6-9]{1}-[\\d]{3,4}-[\\d]{4}$";

    public static final String REGEXP_USER_GENDER = "^[남|여]$";

    public static final String REGEXP_DATE_TYPE5 =
            "\\d{4}-[01]\\d-[0-3]\\d\\s[0-2](\\d:[0-5]\\d:([0-5]\\d)?)?";

}
