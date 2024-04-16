package com.example.co_templates.quests.services;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

@Service
public class QuestBoardService {

    @Autowired
    ShareDao shareDao;

    @Autowired
    Commons commons;

    public Object list(Integer pageNumber, HashMap<String, String> dataMap){
        String sqlMapId = "";
        if (dataMap.size() == 0) {
            sqlMapId = "Board.selectBysearch";
        } else {
            sqlMapId = "Board.selectByUID";
        }
        Object list = shareDao.getList(sqlMapId, dataMap);
        return list;
    }


    public Object BoardList(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);

        return list;
    }

    public Object BoardInsert(HashMap<String,Object> dataMap){
        // xml 파일에서 특정 id로 지정해서 쿼리문 호출
        String sqlMapId = "BoardCode.insert";

        // {
        //     "PK_BOARDS" : "news-020",
        //     "TITLE" :"title",
        //     "CONTENTS" : " test_contents",
        //     "WRITER_ID" : "test_user",
        //     "CREATE_DATE" : "2024-04-15",
        //     "PARENT_BOARDS" : "test_boards"
        // }

        Object insert = shareDao.insert(sqlMapId, dataMap);

        return insert;

    }

    public Object BoardUpdate(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.update";
        Object update = shareDao.update(sqlMapId, dataMap);
        return update;
    }

    public Object BoardDelete(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.delete";
        Object delete = shareDao.delete(sqlMapId, dataMap);

        // {
        //     "PK_BOARDS" : "1b5ec6e8-b9f2-4d74-b923-094c6aa0cc54"
        // }


        return delete;
    }


}
