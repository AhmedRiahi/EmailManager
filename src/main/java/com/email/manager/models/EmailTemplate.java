package com.email.manager.models;

import com.email.manager.models.markup.MarkupModel;

import java.util.List;
import java.util.Set;

public class EmailTemplate {

    private String subject;
    private String content;

    private Set<MarkupModel> subjectMarkups;
    private Set<MarkupModel> contentMarkups;
}
