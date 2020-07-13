package com.neusoft.bsp.System.entity;

public class Menu {
    int menu_id;
    String menu_name;
    String menu_index;
    int parent_id;
    int menu_order;
    String menu_icon;
    String menu_type;

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_index() {
        return menu_index;
    }

    public void setMenu_index(String menu_index) {
        this.menu_index = menu_index;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getMenu_order() {
        return menu_order;
    }

    public void setMenu_order(int menu_order) {
        this.menu_order = menu_order;
    }

    public String getMenu_icon() {
        return menu_icon;
    }

    public void setMenu_icon(String menu_icon) {
        this.menu_icon = menu_icon;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu_id=" + menu_id +
                ", menu_name='" + menu_name + '\'' +
                ", menu_index='" + menu_index + '\'' +
                ", parent_id=" + parent_id +
                ", menu_order=" + menu_order +
                ", menu_icon='" + menu_icon + '\'' +
                ", menu_type='" + menu_type + '\'' +
                '}';
    }
}
