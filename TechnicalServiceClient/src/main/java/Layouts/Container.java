package Layouts;

import Views.LoginView;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class Container extends HorizontalLayout {
    public Container(Header header){

        setWidth(100, Unit.PERCENTAGE);

        Content content = new Content();
        content.setVisible(true);

        SideBar sideBar = new SideBar(header, content);
        sideBar.setVisible(true);

        LoginView loginView = new LoginView();
        loginView.setContent(content);
        loginView.setSideBar(sideBar);

        addComponent(loginView);
        addComponent(sideBar);
        addComponent(content);

        setExpandRatio(sideBar, 2f);
        setExpandRatio(content, 8f);

    }


}
