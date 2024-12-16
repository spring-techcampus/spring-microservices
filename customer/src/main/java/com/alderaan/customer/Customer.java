package com.alderaan.customer;

import com.alderaan.customer.common.constant.Constant;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = Constant.Table.CUSTOMER)
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}