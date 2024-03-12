package com.demo.common.payloads;

import com.demo.common.utils.DateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CommonResponse<T> {
    private Meta meta;
    private T data;
    private List<Link> actions;
    private String message;
    private String error;
    private static String timestamp = DateTimeConverter.getCurrentDateTime();


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Link{
        private String url;
        private String name;
        private String method;
    }

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Meta{
        private long offset;
        private long limit;
    }
}
