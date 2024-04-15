package com.example.co_templates.quests.services;
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

    public Object BoardList(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);

        return list;
    }

    public Object BoardInsert(HashMap<String,Object> dataMap){
        // xml 파일에서 특정 id로 지정해서 쿼리문 호출
        String sqlMapId = "BoardCode.insert";
        // 고유번호 호출후 변수에 대입
        String pkUnique = commons.getUniqueSequence();

        // 컬럼 갯수 만큼 대입
        dataMap.put("PK_BOARDS", pkUnique);
        dataMap.put("TITLE", "test_title");
        dataMap.put("CONTENTS", "test_contesnts");
        dataMap.put("WRITER_ID", "test_user");
        dataMap.put("CREATE_DATE", "2024-04-17");
        dataMap.put("PARENT_BOARDS", "test_BOARDS");

        Object insert = shareDao.insert(sqlMapId, dataMap);

        return insert;
    }

    public Object BoardUpdate(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.update";
        String pkUnique = commons.getUniqueSequence();
        String fkUnique = commons.getUniqueSequence();
        dataMap.put("PK_BOARDS",pkUnique);
        dataMap.put("WRITER_ID",fkUnique);

        Object update = shareDao.update(sqlMapId, dataMap);
        return update;
    }

    public Object BoardDelete(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.delete";
        dataMap.put("PK_BOARDS","1415ae4f-5e0a-432f-947d-8ba94b8e7409");
        Object delete = shareDao.delete(sqlMapId, dataMap);

        return delete;
    }


}
