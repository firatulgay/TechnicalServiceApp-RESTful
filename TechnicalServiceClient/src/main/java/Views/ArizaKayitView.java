package Views;

import Buttons.MyTextField;
import Buttons.SaveButton;
import com.vaadin.ui.*;
import web.client.ArizaRestClient;
import web.client.ClientArizaDto;

import java.util.Date;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class ArizaKayitView extends VerticalLayout {

    private MyTextField idField;
    private MyTextField nameField;
    private DateField dateField;
    private TextArea contentField;
    private ComboBox stateComboBox;
    private TextArea descriptionField;
    private FormLayout mainLayout;

    public ArizaKayitView() {

        buildMainLayout();


}
    private void buildMainLayout() {

        mainLayout = new FormLayout();
        addComponent(mainLayout);

        idField = new MyTextField("Id");
        idField.setEnabled(false);
        mainLayout.addComponent(idField);

        nameField = new MyTextField("Name");
        mainLayout.addComponent(nameField);

        dateField = new DateField("Date");
        mainLayout.addComponent(dateField);

        contentField = new TextArea("Content");
        mainLayout.addComponent(contentField);

        stateComboBox = new ComboBox("State");
        stateComboBox.addItem("FIXED");
        stateComboBox.addItem("ONPROCESS");
        stateComboBox.addItem("UNFIXED");

        mainLayout.addComponent(stateComboBox);

        descriptionField = new TextArea("Description");
        mainLayout.addComponent(descriptionField);

        SaveButton saveButton = new SaveButton();
        saveButton.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

                Long idFieldValue = null;
                if (idField.getValue() != "") {
                    idFieldValue = Long.parseLong(idField.getValue());
                }
                save();
                Notification.show("Kayıt Yapıldı");
            }
        });
        mainLayout.addComponent(saveButton);
    }

    private void save() {
        String nameFieldValue = nameField.getValue();
        Date dateFieldValue = dateField.getValue();
        String contentFieldValue = contentField.getValue();
        String stateComboBoxValue = (String) stateComboBox.getValue();
        String descriptionFieldValue = descriptionField.getValue();

        ClientArizaDto clientArizaDto = new ClientArizaDto();

        clientArizaDto.setAdi(nameFieldValue);
        clientArizaDto.setDate(dateFieldValue);
        clientArizaDto.setContent(contentFieldValue);
        clientArizaDto.setEnumState(stateComboBoxValue);
        clientArizaDto.setDescription(descriptionFieldValue);

        ArizaRestClient arizaRestClient = new ArizaRestClient();
        arizaRestClient.saveClientArizaDto(clientArizaDto);
    }

    public void fillArizaView(ClientArizaDto clientArizaDto){

        idField.setValue(String.valueOf(clientArizaDto.getId()));
        nameField.setValue(clientArizaDto.getAdi());
        dateField.setValue(clientArizaDto.getDate());
        contentField.setValue(clientArizaDto.getContent());
        stateComboBox.setValue(clientArizaDto.getEnumState());
        descriptionField.setValue(clientArizaDto.getDescription());


    }
}
