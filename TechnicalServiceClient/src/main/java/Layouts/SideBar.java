package Layouts;

import Buttons.SideBarButton;
import Views.ArizaKayitView;
import Views.ArizaListView;
import Views.LoginView;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import web.client.ArizaRestClient;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class SideBar extends VerticalLayout {

    private SideBarButton btnArizaKayit;
    private SideBarButton btnArizaList;

    public SideBar(Header header, Content content) {

        setSpacing(true);
        setMargin(true);

        btnArizaKayit = new SideBarButton("Arıza Kayıt");
        btnArizaKayit.setIcon(FontAwesome.SAVE);
        btnArizaKayit.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Label label1 = new Label(btnArizaKayit.getCaption());
                header.setHeaderOzellik(label1);

                ArizaKayitView arizaKayitView = new ArizaKayitView();
                content.setContent(arizaKayitView);
                header.setHeader(label1);

                header.addMenuBar();
                header.getItem1().setEnabled(true);
                header.getItem2().setEnabled(false);
                header.getItem3().setEnabled(false);
                header.getItem4().setEnabled(false);

            }
        });
        addComponent(btnArizaKayit);

        btnArizaList = new SideBarButton("Arıza Sorgu");
        btnArizaList.setIcon(FontAwesome.SEARCH);
        btnArizaList.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Label label1 = new Label(btnArizaList.getCaption());
                header.setHeaderOzellik(label1);

                ArizaListView arizaListView = new ArizaListView();
                content.setContent(arizaListView);
                header.setHeader(label1);

                header.addMenuBar();
                header.getItem1().setEnabled(false);
                header.getItem2().setEnabled(true);
                header.getItem3().setEnabled(false);
                header.getItem4().setEnabled(false);

                getAllAriza();

            }
        });
        addComponent(btnArizaList);


    }

    private void getAllAriza() {
        ArizaRestClient arizaRestClient = new ArizaRestClient();
        arizaRestClient.findAllClientArizaDto();
    }
}