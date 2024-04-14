package com.example.co_templates.quests.services;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.co_templates.daos.ShareDao;
import com.example.co_templates.utils.Commons;

@Service
public class QuestBoardService {
    // public ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();

    @Autowired
    ShareDao shareDao;

    @Autowired
    Commons commons;

    public void callBoardList(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.selectBysearch";
        Object list = shareDao.getList(sqlMapId, dataMap);
    }

    public void callBoardInsert(HashMap<String,Object> dataMap){
        // xml 파일에서 특정 id로 지정해서 쿼리문 호출
        String sqlMapId = "BoardCode.insert";
        // 고유번호 호출후 변수에 대입
        String pkUnique = commons.getUniqueSequence();
        String fkUnique = commons.getUniqueSequence();

        // 컬럼 갯수 만큼 대입
        dataMap.put("PK_BOARDS", pkUnique);
        dataMap.put("TITLE", "test_title");
        dataMap.put("CONTENTS", "test_contesnts");
        dataMap.put("WRITER_ID", fkUnique);
        dataMap.put("PARENT_BOARDS", "test_BOARDS");

        Object insert = shareDao.insert(sqlMapId, dataMap);
    }

    public void callBoardUpdate(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.update";
        String pkUnique = commons.getUniqueSequence();
        String fkUnique = commons.getUniqueSequence();
        dataMap.put("PK_BOARDS",pkUnique);
        dataMap.put("WRITER_ID",fkUnique);

        Object update = shareDao.update(sqlMapId, dataMap);
    }

    public void callBoardDelete(HashMap<String,Object> dataMap){
        String sqlMapId = "BoardCode.delete";
        String pkUnique = commons.getUniqueSequence();
        dataMap.put("PK_BOARDS",pkUnique);
        Object delete = shareDao.delete(sqlMapId, dataMap);

    }



    // public HashMap<String, Object> mixed(String pageNumber, String pkid){
    //     HashMap<String, Object> resultMap = new HashMap<>();
    //     resultMap.put("list", this.list(pageNumber));
    //     resultMap.put("view", this.view(pkid));
    //     resultMap.put("delete", this.delete(pkid));
    //     return resultMap;
    // }
    // public ArrayList<HashMap<String, Object>> insert(String title, String contents) { 
    //     HashMap<String, Object> item = new HashMap<>();
    //     int number = this.itemList.size()+1;
    //     String pk_id = "PK_ID_"+ number;
    //     item.put("PK_ID", pk_id);
    //     item.put("TITLE", title);
    //     item.put("CONTENTS", contents);
    //     this.itemList.add(item);

    //     return this.itemList;
    // }
    // public ArrayList<HashMap<String, Object>> list(String pageNumber){
    //     return this.itemList;
    // }
    // public HashMap<String, Object> view(String pk_id){
    //     HashMap<String,Object> itemDetails = new HashMap<>();
    //     for (int i = 0; i < this.itemList.size();i++){
    //         if (this.itemList.get(i).get("PK_ID").equals(pk_id)){
    //         itemDetails = this.itemList.get(i);
    //     }
    // }
        
    //     return itemDetails;
    // }
    // public Integer delete(String pk_id){
    //     int delete_num = 0;
    //     for (int i = 0; i < this.itemList.size();i++){
    //         if (this.itemList.get(i).get("PK_ID").equals(pk_id)){
    //             this.itemList.remove(i);
    //             delete_num = delete_num + 1;
    //     }
    // }
    //     return delete_num;
    // }
}
