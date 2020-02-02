package com.example.demo.constant;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/2 20:18
 * @Description:
 */
@Data
@Builder
public  class STATUS {
    public static Integer SUCCESS=101;
    public static Integer ERROR=102;
    public static Integer NUM_ERR=103;
}
