package com.andpostman.servicee.dto;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.SplittableRandom;

@Data
public class RandomNumberDescription {

    private int number;
    private String time;
    private String comment;

    public RandomNumberDescription() {
        this.number = new SplittableRandom().nextInt(1,6);
        this.comment = "выполнено";
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    public RandomNumberDescription(int number) {
        this.number = number;
        this.comment = "выполнено";
        this.time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append(number)
                .append(time)
                .append(comment)
                .toString();
    }
}


