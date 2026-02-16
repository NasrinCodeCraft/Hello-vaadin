package com.example.hello_vaadin.post;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

import java.util.List;

@CssImport("./styles/my-styles.css")
@Route("posts")
public class PostsView extends Div {


    public PostsView(PostService postService) {
        setHeightFull();
        Grid<Post> grid = new Grid<>(Post.class,false);
        grid.addClassName("my-grid");
        grid.addColumn(Post::title).setHeader("Title").setAutoWidth(true).setFlexGrow(0);;
        grid.addColumn(Post::summary).setHeader("Summary");
        grid.addColumn(Post::url).setHeader("URL");
        grid.addColumn(Post::datePublished).setHeader("Date Published");
        grid.addThemeVariants(GridVariant.LUMO_COMPACT);
        grid.setHeightFull();

        List<Post> posts = postService.findAll();
        grid.setItems(posts);
        grid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);

        add(grid);
    }
}
