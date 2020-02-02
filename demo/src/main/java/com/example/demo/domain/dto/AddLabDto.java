package com.example.demo.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/2 20:24
 * @Description:
 */
@Data
@Builder
public class AddLabDto {
    Integer userId;
    String name;
    String desc;
}
