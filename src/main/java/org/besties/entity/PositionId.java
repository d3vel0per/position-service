package org.besties.entity;

import java.io.Serializable;
import java.util.Objects;

public class PositionId implements Serializable {
    private String accountId;
    private String securityId;

    public PositionId() {}

    public PositionId(String accountId, String securityId) {
        this.accountId = accountId;
        this.securityId = securityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionId that = (PositionId) o;
        return accountId.equals(that.accountId) &&
                securityId.equals(that.securityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, securityId);
    }

    @Override
    public String toString() {
        return "PositionId{" +
                "accountId='" + accountId + '\'' +
                ", securityId='" + securityId + '\'' +
                '}';
    }
}
