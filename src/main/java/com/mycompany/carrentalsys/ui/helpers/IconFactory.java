/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrentalsys.ui.helpers;

import com.formdev.flatlaf.extras.FlatSVGIcon;

/**
 *
 * @author heinz
 */
public class IconFactory {
    // size for icons in buttons
    private static final int WIDTH_BTN = 20;
    private static final int HEIGHT_BTN = 20;
    
    // size for icons in top menu
    private static final int WIDTH_MENU = 12;
    private static final int HEIGHT_MENU = 12;
    
    public static FlatSVGIcon getBtnIconDelete() {
        return new FlatSVGIcon("images/svg/delete.svg", IconFactory.WIDTH_BTN, IconFactory.HEIGHT_BTN);
    }
    
    public static FlatSVGIcon getBtnIconEdit() {
        return new FlatSVGIcon("images/svg/edit.svg", IconFactory.WIDTH_BTN, IconFactory.HEIGHT_BTN);
    }
    
    public static FlatSVGIcon getBtnIconSave() {
        return new FlatSVGIcon("images/svg/save.svg", IconFactory.WIDTH_BTN, IconFactory.HEIGHT_BTN);
    }
    
    public static FlatSVGIcon getBtnIconRent() {
        return new FlatSVGIcon("images/svg/rent.svg", IconFactory.WIDTH_BTN, IconFactory.HEIGHT_BTN);
    }
    
    public static FlatSVGIcon getBtnIconReturn() {
        return new FlatSVGIcon("images/svg/return.svg", IconFactory.WIDTH_BTN, IconFactory.HEIGHT_BTN);
    }
    
    public static FlatSVGIcon getBtnIconAdd() {
        return new FlatSVGIcon("images/svg/add.svg", IconFactory.WIDTH_BTN, IconFactory.HEIGHT_BTN);
    }
    
    public static FlatSVGIcon getMenuIconManage() {
        return new FlatSVGIcon("images/svg/manage.svg", IconFactory.WIDTH_MENU, IconFactory.HEIGHT_MENU);
    }
    
    public static FlatSVGIcon getMenuIconHistory() {
        return new FlatSVGIcon("images/svg/history.svg", IconFactory.WIDTH_MENU, IconFactory.HEIGHT_MENU);
    }
    
    public static FlatSVGIcon getMenuIconAbout() {
        return new FlatSVGIcon("images/svg/about.svg", IconFactory.WIDTH_MENU, IconFactory.HEIGHT_MENU);
    }
    
}
