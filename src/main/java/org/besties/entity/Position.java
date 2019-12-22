package org.besties.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(PositionId.class)
public class Position {
    @Id private String accountId;
    @Id private String securityId;
    private Long longQuantity;
    private Long shortQuantity;

    public Position() {}

    public Position(String accountId, String securityId, Long longQuantity, Long shortQuantity) {
        this.accountId = accountId;
        this.securityId = securityId;
        this.longQuantity = longQuantity;
        this.shortQuantity = shortQuantity;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public Long getLongQuantity() {
        return longQuantity;
    }

    public void setLongQuantity(Long longQuantity) {
        this.longQuantity = longQuantity;
    }

    public Long getShortQuantity() {
        return shortQuantity;
    }

    public void setShortQuantity(Long shortQuantity) {
        this.shortQuantity = shortQuantity;
    }
}
