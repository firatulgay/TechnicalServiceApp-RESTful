package Layouts;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class Header extends VerticalLayout {

    MenuBar.MenuItem item1;
    MenuBar.MenuItem item2;
    MenuBar.MenuItem item3;
    MenuBar.MenuItem item4;

    public Header(Label label) {

        setHeaderOzellik(label);
        addMenuBar();
    }

    void addMenuBar() {

        MenuBar menuBar = new MenuBar();
        menuBar.setWidth(100, Unit.PERCENTAGE);
        addComponent(menuBar);

        item1 = menuBar.addItem("Menü1", FontAwesome.AMAZON, null);
        item2 = menuBar.addItem("Menü2", FontAwesome.BELL, null);
        item3 = menuBar.addItem("Menü3", FontAwesome.CHAIN, null);
        item4 = menuBar.addItem("Menü4", FontAwesome.FAST_BACKWARD, null);

        item1.setEnabled(false);
        item2.setEnabled(false);
        item3.setEnabled(false);
        item4.setEnabled(false);
    }


    public void setHeaderOzellik(Label label) {
        setWidth(100, Unit.PERCENTAGE);
        setHeight(100, Unit.PIXELS);
        label.addStyleName(ValoTheme.TEXTAREA_ALIGN_CENTER);
        label.addStyleName(ValoTheme.LABEL_HUGE);
        label.addStyleName(ValoTheme.LABEL_BOLD);

    }

    public void setHeader(Component component) {
        this.removeAllComponents();
        addComponent(component);
    }

    public MenuBar.MenuItem getItem1() {
        return item1;
    }

    public void setItem1(MenuBar.MenuItem item1) {
        this.item1 = item1;
    }

    public MenuBar.MenuItem getItem2() {
        return item2;
    }

    public void setItem2(MenuBar.MenuItem item2) {
        this.item2 = item2;
    }

    public MenuBar.MenuItem getItem3() {
        return item3;
    }

    public void setItem3(MenuBar.MenuItem item3) {
        this.item3 = item3;
    }

    public MenuBar.MenuItem getItem4() {
        return item4;
    }

    public void setItem4(MenuBar.MenuItem item4) {
        this.item4 = item4;
    }
}
