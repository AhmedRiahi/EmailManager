package com.email.manager.models;

import lombok.Data;

import java.util.List;

@Data
public class RenderedEmailModel {


    private List<String> receivers;
    private String subject;
    private String content;

}
