package com.example.co_templates.restapis;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.co_templates.services.BoardService;

@RestController
public class BoardRestController {

    @Autowired 
    BoardService BoardService;
    
    // /r/board/list/{page}?searchword={word}
    // /r/board/list/2?searchword=coco lang
    @GetMapping({"/r/board/list/{pageNumber}","/r/board/list"})
    public ResponseEntity<Object> callBoardList(@PathVariable(required = false) String pageNumber, @RequestBody HashMap<String,Object> dataMap) {
        Object list = BoardService.list(dataMap);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/r/board/insert")
    public void callBoardInsert(HashMap dataMap) {
        BoardService.insert(dataMap);
        return;
    }

    @GetMapping("/r/board/update")
    public void callBoardUpdate(HashMap dataMap) {
        BoardService.update(dataMap);
        return;
    }

    @GetMapping("/r/board/delete")
    public void callBoardDelete(HashMap dataMap) {
        BoardService.delete(dataMap);
        return;
    }

    
}