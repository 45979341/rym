package com.pingan.rym.dto;

/**
 * @author 刘欣武
 * @version $Id: ItemParamDTO, v 0.1 2019/6/25 11:26 刘欣武 Exp$
 */
public class ItemParamDTO {

    private int id;
    private String group_name;
    private int item_cat_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public int getItem_cat_id() {
        return item_cat_id;
    }

    public void setItem_cat_id(int item_cat_id) {
        this.item_cat_id = item_cat_id;
    }
}


