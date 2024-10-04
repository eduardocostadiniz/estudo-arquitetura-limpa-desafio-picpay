package com.eduardo.core.domain;

import com.eduardo.core.exception.TransactionPinException;
import com.eduardo.core.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {

    private static final Integer NUMBER_OF_CHANCES = 3;
    private Long id;
    private String pin;
    private Integer attempt;
    private Boolean blocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin() {
    }

    public TransactionPin(String pin) {
        this.setPin(pin);
        this.attempt = TransactionPin.NUMBER_OF_CHANCES;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin(Long id, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.isPinValid(pin);
        this.pin = pin;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt() {
        if (this.attempt == 1) {
            this.blocked = true;
            this.attempt = 0;
        } else {
            this.attempt--;
        }
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionPin that)) return false;

        return Objects.equals(getId(), that.getId()) && getPin().equals(that.getPin()) && getAttempt().equals(that.getAttempt()) && getBlocked().equals(that.getBlocked()) && getCreatedAt().equals(that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getId());
        result = 31 * result + getPin().hashCode();
        result = 31 * result + getAttempt().hashCode();
        result = 31 * result + getBlocked().hashCode();
        result = 31 * result + getCreatedAt().hashCode();
        result = 31 * result + Objects.hashCode(getUpdatedAt());
        return result;
    }

    private void isPinValid(String pin) {
        if (pin.length() != 8) {
            throw new TransactionPinException(ErrorCodeEnum.TP0001.getMessage(), ErrorCodeEnum.TP0001.getCode());
        }
    }

    public void resetAttempts() {
        this.attempt = TransactionPin.NUMBER_OF_CHANCES;
    }
}
