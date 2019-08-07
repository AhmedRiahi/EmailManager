package com.email.manager.models;

import com.email.manager.models.markup.MarkupMeta;
import lombok.Data;

import java.util.Set;

@Data
public class EmailTemplate {

    private String name;
    private String subject;
    private String content;

    private Set<MarkupMeta> subjectMarkups;
    private Set<MarkupMeta> contentMarkups;
}
