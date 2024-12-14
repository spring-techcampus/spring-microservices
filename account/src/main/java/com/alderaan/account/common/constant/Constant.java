package com.alderaan.account.common.constant;

public final class Constant {

    private Constant() {
        // Private constructor to prevent instantiation
    }

    /**
     * Nested class that contains constants related to database table names.
     */
    public static final class Table {
        public static final String ACCOUNT = "accounts";
        // add more constants as needed (in alphabetical order)

        Table() {
            throwUnsupportedOperationException();
        }
    }

    /**
     * Throws an UnsupportedOperationException to indicate that this class cannot be instantiated.
     */
    private static void throwUnsupportedOperationException() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
