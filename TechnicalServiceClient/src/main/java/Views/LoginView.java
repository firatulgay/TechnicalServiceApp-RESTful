package Views;

import Buttons.MyTextField;
import Buttons.SaveButton;
import Layouts.Content;
import Layouts.SideBar;
import com.vaadin.ui.*;
import web.client.ClientLoginDto;
import web.client.LoginRestClient;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class LoginView extends VerticalLayout {

    private MyTextField nameField;
    private MyTextField passwordField;
    private FormLayout mainLayout;

    private Content content;
    private SideBar sideBar;

    public LoginView() {

        buildMainLayout();
    }

    private void buildMainLayout() {
        mainLayout = new FormLayout();
        addComponent(mainLayout);

        nameField = new MyTextField("Name");
        mainLayout.addComponent(nameField);

        passwordField = new MyTextField("Password");
        mainLayout.addComponent(passwordField);

        Button loginButton = new Button();
        loginButton.setCaption("Login");
        loginButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                String nameFieldValue = nameField.getValue();
                String passwordFieldValue = passwordField.getValue();

                try {
                    LoginRestClient loginRestClient = new LoginRestClient();
                    ClientLoginDto allClientLoginDto = loginRestClient.findAllClientLoginDto();

                    String clientAdi = allClientLoginDto.getAdi();
                    String clientSifre = allClientLoginDto.getSifre();

                    if (clientAdi.equals(nameFieldValue) && clientSifre.equals(passwordFieldValue)) {
                        getContent().setVisible(true);
                        getSideBar().setVisible(true);
                        setVisible(false);
                    } else {
                        Notification.show("Hatalı isim veya şifre");
                    }
                } catch (Exception e) {
                    System.out.println("Serverda hata oluştu");
                    e.printStackTrace();
                }
            }
        });
        mainLayout.addComponent(loginButton);
    }

    public Content getContent() {
        return content;
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public void setSideBar(SideBar sideBar) {
        this.sideBar = sideBar;
    }
}
