package com.example.co_templates.quests.restapis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.co_templates.quests.services.QuestBoardService;
import com.example.co_templates.quests.services.QuestCommentsService;


@RestController
public class QuestBoardController {

    @Autowired 
    QuestBoardService BoardService;

    @Autowired
    QuestCommentsService CommentsService;

    @GetMapping("/q/r/board/callBoardList")
    public void callBoardList(HashMap<String,Object> datMap) {
        BoardService.callBoardList(datMap);
        return;
    }

    @GetMapping("/q/r/board/callBoardInsert")
    public void callBoardInsert(HashMap datMap) {
        BoardService.callBoardInsert(datMap);
        return;
    }

    @GetMapping("/q/r/board/callBoardUpdate")
    public void callBoardUpdate(HashMap datMap) {
        BoardService.callBoardUpdate(datMap);
        return;
    }

    @GetMapping("/q/r/board/callBoardDelete")
    public void callBoardDelete(HashMap datMap) {
        BoardService.callBoardDelete(datMap);
        return;
    }

    @GetMapping("/q/r/comments/callCommentsList")
    public void callCommentsList(HashMap datMap) {
        CommentsService.callCommentsList(datMap);
        return;
    }

    @GetMapping("/q/r/comments/callCommentsInsert")
    public void callCommentsInsert(HashMap datMap) {
        CommentsService.callCommentsInsert(datMap);
        return;
    }
    
    @GetMapping("/q/r/comments/callCommentsUpdate")
    public void callCommentsUpdate(HashMap datMap) {
        CommentsService.callCommentsUpdate(datMap);
        return;
    }

    @GetMapping("/q/r/comments/callCommentsDelete")
    public void callCommentsDelete(HashMap datMap) {
        CommentsService.callCommentsDelete(datMap);
        return;
    }
    

    // @GetMapping("/q/r/board/mixed/{pageNumber}/{pk_id}")
    // public ResponseEntity<HashMap<String, Object>> mixed(@PathVariable("pageNumber") String pageNumber,
    //         @PathVariable("pk_id") String pkId) {
    //     // call service
    //     HashMap<String, Object> resultMap = new HashMap<>();
    //     resultMap = BoardService.mixed(pageNumber, pkId);

    //     // add request params 
    //     HashMap<String, Object> requestParams = new HashMap<>();
    //     requestParams.put("pageNumber", pageNumber);
    //     requestParams.put("pk_id", pkId);
    //     resultMap.put("requestParams", requestParams);

    //     return ResponseEntity.ok().body(resultMap);
    // }

    // @GetMapping("/q/r/board/list/{pageNumber}")
    // public ResponseEntity<List<HashMap<String, Object>>> list(@PathVariable("pageNumber") String pageNumber) {
    //     ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
    //     // CommonCodeService commonCodeService = new CommonCodeService();
    //     itemList = BoardService.list(pageNumber);
    
    //     return ResponseEntity.ok().body(itemList);
    // }
    // @GetMapping("/q/r/board/insert/{title}/{contents}")
    // public ResponseEntity<Integer> insert(@PathVariable("title") String title, @PathVariable("contents") String contents) {
    //     ArrayList<HashMap<String, Object>> itemList = new ArrayList<HashMap<String, Object>>();
    //     // CommonCodeService commonCodeService = new CommonCodeService();
    //     itemList = BoardService.insert(title,contents);
    
    //     return ResponseEntity.ok().body(itemList.size());
    // }
    // @GetMapping("q/r/board/view/{pk_id}")
    // public ResponseEntity<HashMap<String, Object>> view(@PathVariable("pk_id") String pkId) {
    //     HashMap<String, Object> itemDetails = new HashMap<>();
    //     itemDetails = BoardService.view(pkId);

    //     return ResponseEntity.ok().body(itemDetails);
    // }
    // @GetMapping("q/r/board/delete/{pk_id}")
    // public ResponseEntity<Integer> delete(@PathVariable("pk_id") String pkId) {
    //     int delete_num = BoardService.delete(pkId);

    //     return ResponseEntity.ok().body(delete_num);
    // }
}
