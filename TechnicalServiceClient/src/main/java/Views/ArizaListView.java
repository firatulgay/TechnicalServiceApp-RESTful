package Views;

import Buttons.MyTextField;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.shared.ui.MultiSelectMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import web.client.ArizaRestClient;
import web.client.ClientArizaDto;

import java.util.Date;

/**
 * Created by FiratUlgay on 19.12.2019.
 */
public class ArizaListView extends HorizontalLayout {

    MyTextField searchTextField;
    Button btnSearch;
    private Table table;
    private IndexedContainer indexedContainer;
    ArizaKayitView arizaKayitView ;
    FormLayout formLayout;

    public ArizaListView() {
        setSpacing(true);

        buidSearchComponents();

        buildTableContainer();
        buildTable();

        arizaKayitView = new ArizaKayitView();
        addComponent(arizaKayitView);

        fillTable();

    }

    private void fillTable() {

        ArizaRestClient arizaRestClient = new ArizaRestClient();

        ClientArizaDto[] allClientArizaDto = arizaRestClient.findAllClientArizaDto();
        for (ClientArizaDto clientArizaDto : allClientArizaDto) {
            Item item = indexedContainer.addItem(clientArizaDto);

            item.getItemProperty("id").setValue(clientArizaDto.getId());
            item.getItemProperty("name").setValue(clientArizaDto.getAdi());
            item.getItemProperty("date").setValue(clientArizaDto.getDate());
            item.getItemProperty("content").setValue(clientArizaDto.getContent());
            item.getItemProperty("state").setValue(clientArizaDto.getEnumState());
            item.getItemProperty("description").setValue(clientArizaDto.getDescription());

        }
    }

    private void buidSearchComponents() {
        formLayout = new FormLayout();

        searchTextField = new MyTextField("Id");

        btnSearch = new Button();
        btnSearch.setCaption("Search");

        formLayout.addComponent(searchTextField);
        formLayout.addComponent(btnSearch);

        addComponent(formLayout);
    }

    private void buildTableContainer() {

        indexedContainer = new IndexedContainer();
        indexedContainer.addContainerProperty("id", Long.class, null);
        indexedContainer.addContainerProperty("name", String.class, null);
        indexedContainer.addContainerProperty("date", Date.class, null);
        indexedContainer.addContainerProperty("content", String.class, null);
        indexedContainer.addContainerProperty("state", String.class, null);
        indexedContainer.addContainerProperty("description", String.class, null);

    }


    private void buildTable() {
        table = new Table();
        table.setContainerDataSource(indexedContainer);
        table.setColumnHeaders("ID", "NAME","DATE","CONTENT","STATE","DESCRIPTION");
        table.setSelectable(true);
        table.setMultiSelectMode(MultiSelectMode.SIMPLE);
        table.setMultiSelect(false);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent itemClickEvent) {

                ClientArizaDto clientArizaDto = new ClientArizaDto();

                arizaKayitView.fillArizaView(clientArizaDto);

            }
            });addComponent(table);
        }

}
