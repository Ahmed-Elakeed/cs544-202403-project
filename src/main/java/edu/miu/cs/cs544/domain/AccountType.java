package edu.miu.cs.cs544.domain;

public enum AccountType {
	
    DINING, CLASS, GYM;
    public static AccountType getEnumFromString(String value) {
        if (value == null) {
            return null;
        }
        for (AccountType type : AccountType.values()) {
            if (value.equalsIgnoreCase(type.toString())) {
                return type;
            }
        }
        throw new IllegalArgumentException("No constant with text " + value);
    }
}
