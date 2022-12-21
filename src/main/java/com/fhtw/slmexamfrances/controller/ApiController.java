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
    ///tax?netprice=12.22&taxpercent=20
    @GetMapping(value = "/api/tax")
    public ResponseEntity<String> getRequest(@RequestParam(value = "netprice") String price,
                                             @RequestParam(value = "taxpercent")String pecent) {
        try {
            model.setPrice(Double.parseDouble(price));
            model.setTaxPercent(Double.parseDouble(pecent));
            double result = model.calculateTax();
            return ResponseEntity.ok(String.format("%f",result));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
