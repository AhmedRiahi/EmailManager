package com.email.manager.services.renderer;

import com.email.manager.exceptions.MarkupMetaNotFoundException;
import com.email.manager.models.EmailTemplate;
import com.email.manager.models.RenderedEmailModel;
import com.email.manager.models.markup.MarkupMeta;

import java.util.Map;

public class EmailRenderer {

    private EmailTemplate emailTemplate;
    private Map<MarkupMeta,Object> markupValues;
    private RenderedEmailModel renderedEmailModel;

    private void renderContent(){
        String rendredContent =  this.emailTemplate.getContent();
        for( Map.Entry<MarkupMeta,Object> entry : this.markupValues.entrySet()){
            MarkupMeta markupMeta = entry.getKey();
            Object markupValue = entry.getValue();
            switch (entry.getKey().getType()){
                case TEXT: rendredContent = rendredContent.replaceAll(markupMeta.getName(),markupValue.toString()); break;
                case IMAGE: rendredContent = rendredContent.replaceAll(markupMeta.getName(), "<img src=\"cid:image\">");
            }
        }
        this.renderedEmailModel.setContent(rendredContent);
    }

    public void bind(MarkupMeta markupMeta,Object value){
        this.markupValues.put(markupMeta,value);
    }

    public void bind(String markupName,Object value){
        this.markupValues.put(this.getMarkupMetaByName(markupName),value);
    }


    public MarkupMeta getMarkupMetaByName(String markupName){
        return this.markupValues.keySet().stream().filter(markupMeta -> markupMeta.getName().equals(markupName)).findFirst().orElseThrow(() -> new MarkupMetaNotFoundException());
    }

}
