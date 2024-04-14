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
import com.example.co_templates.quests.services.QuestVisitorsService;


@RestController
public class QuestBoardController {

    @Autowired 
    QuestBoardService BoardService;

    @Autowired
    QuestVisitorsService CommentsService;

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
    public void callVisitorsList(HashMap datMap) {
        CommentsService.callVisitorsList(datMap);
        return;
    }

    @GetMapping("/q/r/comments/callCommentsInsert")
    public void callVisitorsInsert(HashMap datMap) {
        CommentsService.callVisitorsInsert(datMap);
        return;
    }
    
    @GetMapping("/q/r/comments/callCommentsUpdate")
    public void callVisitorsUpdate(HashMap datMap) {
        CommentsService.callVisitorsUpdate(datMap);
        return;
    }

    @GetMapping("/q/r/comments/callCommentsDelete")
    public void callVisitorsDelete(HashMap datMap) {
        CommentsService.callVisitorsDelete(datMap);
        return;
    }
    
}
