package com.cute.play.order;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

/**
 * @author hanyuting
 * @since 2019/2/1
 */
@Component
public class BeforeSaveListener extends AbstractMongoEventListener<BaseEntity> {

    @Override
    public void onBeforeConvert(BeforeConvertEvent<BaseEntity> event){
        DateTime timestamp = new DateTime();
        BaseEntity source = event.getSource();
        if(source.getCreatedAt()==null){
            source.setCreatedAt(timestamp);
        }

        source.setLastModified(timestamp);

        super.onBeforeConvert(event);
    }
}
