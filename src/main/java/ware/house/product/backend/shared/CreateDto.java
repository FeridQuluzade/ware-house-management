package ware.house.product.backend.shared;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class CreateDto {

    @JsonIgnore
    private LocalDateTime createdDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
