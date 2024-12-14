package com.alderaan.account;

import com.alderaan.account.common.constant.Constant;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = Constant.Table.ACCOUNT)
class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    public Account(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account() {
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