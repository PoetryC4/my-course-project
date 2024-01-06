package com.companypowernode.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * info of a stock

 * </p>
 *
 * @author ly
 * @since 2023-03-21
 */
@TableName("stock_info")
@Data
public class StockInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ts_code", type = IdType.AUTO)
    private String tsCode;

    private String symbol;

    private String stoName;

    private String area;

    private String industry;

    private String fullname;

    private String enname;

    private String market;

    private String exchange;

    private String currType;

    private String listStatus;

    private LocalDate listDate;

    private LocalDate delistDate;

    private Double score;

    private String scoreDate;

}
