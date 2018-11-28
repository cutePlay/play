package com.cute.play.drama.vo;

import com.cute.play.drama.entity.DramaInfo;
import com.cute.play.drama.entity.DramaScene;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author hanyuting
 * @since 2018/11/28
 */
@Getter
@Setter
@ToString
public class GameRoomInfo {
    /**
     * 默认场景信息
     */
    private List<DramaInfo> infos;
    /**
     * 场景列表
     */
    private List<DramaScene> scenes;
    /**
     * 当前场景标识
     */
    private Byte sceneFlag;

    /**
     * 剧本标识
     */
    private Long dramaId;

    /**
     * 房间标识
     */
    private Long id;
}
