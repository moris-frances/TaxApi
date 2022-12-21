package com.fhtw.slmexamfrances.controller;

import com.fhtw.slmexamfrances.model.ApiModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final ApiModel model = new ApiModel();

//    @RequestMapping(value = "/api/get")
//    public ResponseEntity<String> getRequest() {
//
//        //return ResponseEntity.ok(model.getPrice());
//    }
//    @GetMapping(value = "/api/set")
//    public ResponseEntity<String> setRequest(@RequestParam(value = "m") String message) {
////        try {
////            model.setData(message);
////            return ResponseEntity.ok("Message was set");
////        } catch (Exception e) {
////            return ResponseEntity.badRequest().body(e.getMessage());
////        }
//    }

}
