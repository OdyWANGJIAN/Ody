package com.qianfeng.mybatis.dto;

import java.util.List;

/**
 * Created by Mao on 2018/3/19.
 */
public class DepartmentDTO {
    private int dpmtId;
    private String dpmtName;
    private List<User2DTO> list;

    public List<User2DTO> getList() {
        return list;
    }

    public void setList(List<User2DTO> list) {
        this.list = list;
    }

    public String getDpmtName() {
        return dpmtName;
    }

    public void setDpmtName(String dpmtName) {
        this.dpmtName = dpmtName;
    }

    public int getDpmtId() {
        return dpmtId;
    }

    public void setDpmtId(int dpmtId) {
        this.dpmtId = dpmtId;
    }
}
