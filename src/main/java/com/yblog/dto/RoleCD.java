package com.yblog.dto;

public enum RoleCD {

    NORMAL("N", "NORMAL"),
    SPECIAL("S", "SPECIAL"),
    ADMIN("A", "ADMIN");

    public final String str;
    public final String securityName;

    RoleCD(String str, String securityName) {
        this.str = str;
        this.securityName = securityName;
    }

    public static RoleCD of(String str) {
        for (RoleCD cur : RoleCD.values()) {
            if (str.equals(cur.str)) {
                return cur;
            }
        }\

        return null;
//        throw new AuthException("잘못된 롤입니다");
    }
}
