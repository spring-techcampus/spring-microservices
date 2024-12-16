package com.alderaan.customer.common.constant;

public final class HttpConstant {

    /**
     * Private constructor to prevent instantiation.
     * Throws an UnsupportedOperationException if called.
     */
    HttpConstant() {
        throwUnsupportedOperationException();
    }

    /**
     * Nested class that contains constants related to HTTP request methods.
     */
    public static final class Request {
        public static final class Path {
            public static final String CUSTOMER = "/customers";
            // add more constants as needed (in alphabetical order)

            Path() {
                throwUnsupportedOperationException();
            }
        }
        Request() {
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