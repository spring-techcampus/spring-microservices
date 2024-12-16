package com.alderaan.customer;

import java.util.UUID;

record CustomerDto(
        UUID id,
        String name
) {
}