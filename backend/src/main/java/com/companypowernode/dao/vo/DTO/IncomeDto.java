package com.companypowernode.dao.vo.DTO;
import com.companypowernode.dao.entity.Income;
import lombok.Data;

@Data
public class IncomeDto extends Income {
    private  String year;
}
