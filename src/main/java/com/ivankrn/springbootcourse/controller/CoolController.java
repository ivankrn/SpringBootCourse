package com.ivankrn.springbootcourse.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


@RestController
public class CoolController {

    @GetMapping("/echoHeaders")
    public String echoHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        StringBuilder sb = new StringBuilder();
        headers.forEach((k, v) -> {
            sb.append(String.format("Header: %s, values: %s\n", k, v));
        });
        return sb.toString();
    }

    @PostMapping("/chooseForceSide")
    public ResponseEntity<String> chooseForceSide(@RequestBody String side) {
        if (!side.equals("light") && !side.equals("dark")) {
            throw new WrongSideException();
        }
        return ResponseEntity.ok().body("You chose the right side of Force, well done!");
    }

    @PostMapping("/addId")
    public ResponseEntity<String> addIdToJson(@RequestBody String inputJson) throws JSONException {
        JSONObject jsonObject = new JSONObject(inputJson);
        jsonObject.put("id", 123);
        return ResponseEntity.ok().body(jsonObject.toString());
    }

    @ExceptionHandler(WrongSideException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ResponseEntity<String> handleWrongSideException(WrongSideException exception) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("You chose the wrong side of Force, try again!");
    }
}
