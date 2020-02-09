package com.example.demo.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/3 20:05
 * @Description:
 */
@Data
@Builder
public class ModLabDto {

    Integer userId;
    Integer lId;
    String lName;
    String lDesc;

}
