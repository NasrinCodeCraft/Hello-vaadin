package com.example.hello_vaadin;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./styles/my-styles.css")
public class MainView extends VerticalLayout {
    public MainView() {
        VerticalLayout todosList = new VerticalLayout();
        TextField textField = new TextField();
        textField.addClassName("my-textfield");
        Button addButton = new Button("Add");
        addButton.addClickListener(e -> {
            Checkbox checkbox = new Checkbox(textField.getValue());
            checkbox.addClassName("my-checkbox");
            todosList.add(checkbox);
            textField.setValue("");
        });
        addButton.addClickShortcut(Key.ENTER);

        add(new H1("Vaadin Todo!"), todosList, new HorizontalLayout(textField, addButton));
    }
}
