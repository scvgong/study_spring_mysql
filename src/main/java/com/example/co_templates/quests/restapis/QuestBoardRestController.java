package com.example.co_templates.quests.restapis;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.co_templates.quests.services.QuestBoardService;
import com.example.co_templates.quests.services.QuestVisitorsService;

import ch.qos.logback.core.model.processor.PhaseIndicator;


@RestController
public class QuestBoardRestController {

    @Autowired 
    QuestBoardService BoardService;

    @Autowired
    QuestVisitorsService VisitorsService;

    @GetMapping("/q/boards/list")
    public ModelAndView list(ModelAndView modelAndView, @RequestParam HashMap<String, String> dataMap) {
        Object itemList = new ArrayList<HashMap<String, Object>>();
        // Call Service with Pure Java
        // CommonCodeService commonCodeService = new CommonCodeService();
        itemList = BoardService.list(1,dataMap);

        String viewPath = "/WEB-INF/views/boards/list.jsp";

        // modelAndView에 담겨야 된다.
        modelAndView.setViewName(viewPath);
        modelAndView.addObject("itemList", itemList);
        modelAndView.addObject("dataMap", dataMap);

        return modelAndView;
    }
    @GetMapping({"/q/r/board/BoardList/{pageNumber}","/q/r/board/BoardList"})
    public ResponseEntity<Object> BoardList(@PathVariable(required = false) String pageNumber, @RequestBody HashMap<String,Object> dataMap) {
        Object list = BoardService.BoardList(dataMap);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping({"/q/r/board/BoardInsert/{pageNumber}","/q/r/board/BoardInsert"})
    public ResponseEntity<Object> BoardInsert (@PathVariable(required = false) String pageNumber, @RequestBody HashMap<String,Object> dataMap) {
        Object insert = BoardService.BoardInsert(dataMap);
        return ResponseEntity.ok().body(insert);
    }

    @GetMapping({"/q/r/board/BoardUpdate/{pageNumber}","/q/r/board/BoardUpdate"})
    public ResponseEntity<Object> BoardUpdate(@PathVariable(required = false) String pageNumber,@RequestBody HashMap<String,Object> dataMap) {
        Object update = BoardService.BoardUpdate(dataMap);
        return ResponseEntity.ok().body(update);
    }

    @GetMapping({"/q/r/board/BoardDelete/{pageNumber}","/q/r/board/BoardDelete"})
    public ResponseEntity<Object> BoardDelete(@PathVariable(required = false) String pageNumber,@RequestBody HashMap<String,Object> dataMap) {
        Object delete = BoardService.BoardDelete(dataMap);
        return ResponseEntity.ok().body(delete);
    }

    @GetMapping({"/q/r/Visitors/VisitorsList/{pageNumber}","/q/r/Visitors/VisitorsList"})
    public ResponseEntity<Object> VisitorsList(@PathVariable(required = false) String pageNumber,@RequestBody HashMap<String,Object> dataMap) {
        Object list = VisitorsService.VisitorsList(dataMap);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping({"/q/r/Visitors/VisitorsInsert/{pageNumber}","/q/r/Visitors/VisitorsInsert"})
    public ResponseEntity<Object> VisitorsInsert(@PathVariable(required = false) String pageNumber,@RequestBody HashMap<String,Object> dataMap) {
        Object insert = VisitorsService.VisitorsInsert(dataMap);
        return ResponseEntity.ok().body(insert);
    }
    
    @GetMapping({"/q/r/Visitors/VisitorsUpdate/{pageNumber}","/q/r/Visitors/VisitorsUpdate"})
    public ResponseEntity<Object> VisitorsUpdate(@PathVariable(required = false) String pageNumber,@RequestBody HashMap<String,Object> dataMap) {
        Object update = VisitorsService.VisitorsUpdate(dataMap);
        return ResponseEntity.ok().body(update);
    }

    @GetMapping({"/q/r/Visitors/VisitorsDelete/{pageNumber}","/q/r/Visitors/VisitorsDelete"})
    public ResponseEntity<Object> VisitorsDelete(@PathVariable(required = false) String pageNumber,@RequestBody HashMap<String,Object> dataMap) {
        Object delete = VisitorsService.VisitorsDelete(dataMap);
        return ResponseEntity.ok().body(delete);
    }
    
}