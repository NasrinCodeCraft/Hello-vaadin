package com.example.hello_vaadin.post;

import org.objectweb.asm.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    private final List<Post> posts = new ArrayList<>();
    private final ObjectMapper mapper = new ObjectMapper();

    public PostService() {
        loadPosts();
    }

    private void loadPosts() {
        String path = "data/posts.json";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                log.error("فایل پیدا نشد: {}", path);
                log.info("مسیرهای ممکن: src/main/resources/data/posts.json");
                return;   // The list remains empty – the app does not crash.
            }

            log.info("فایل پیدا شد → شروع لود");

            Post[] initial = mapper.readValue(is, Post[].class);
            posts.addAll(Arrays.asList(initial));

            log.info("تعداد پست‌های لود شده: {}", posts.size());

        } catch (Exception e) {
            log.error("خطا در لود posts.json", e);
        }
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts);
    }
}