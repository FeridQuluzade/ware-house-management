package shared;

import java.time.LocalDateTime;

public class UpdateDto {
    private LocalDateTime updatedDate;

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
