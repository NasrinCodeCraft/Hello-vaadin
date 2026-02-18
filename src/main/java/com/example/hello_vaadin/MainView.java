package com.example.hello_vaadin;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
@CssImport("./styles/my-styles.css")
@CssImport("./styles/jalaliDate.css")
@JsModule("./js/jalaliDate.js")

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

        H1 title = new H1("Vaadin Todo!");
        title.getStyle().set("width", "100%");
        title.getStyle().set("text-align", "center");
        title.getStyle().set("color", "hotpink");

        Div container = new Div();
        container.getStyle().set("width", "100%");
        container.getStyle().set("display", "flex");
        container.getStyle().set("justify-content", "center");
        container.getStyle().set("align-items", "center");

        container.add(new HorizontalLayout(textField, addButton));
        add(title, todosList, container);

        Html html = new Html("<input id='date' type=\"text\" data-jdp placeholder=\"لطفا یک تاریخ وارد نمایید\" />\n" + "    <input type=\"");
        add(html);
    }
}
