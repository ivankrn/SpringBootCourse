package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.model.Bug;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/bugs")
public class BugController {

    @GetMapping("/echoHeaders")
    public String echoHeaders(@RequestHeader MultiValueMap<String, String> headers) {
        StringBuilder sb = new StringBuilder();
        headers.forEach((k, v) -> {
            sb.append(String.format("Header: %s, values: %s\n", k, v));
        });
        return sb.toString();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Bug> getBugById(@PathVariable int id) {
        if (true) {
            throw new NotFoundException(); //как будто в репозитории не нашлось бага с таким id
        }
        return ResponseEntity.ok().body(new Bug()); // пока что заглушка
    }

    @PostMapping("/addId")
    public ResponseEntity<Map<String, String>> addIdToJson(@RequestBody Map<String, String> inputJson) {
        Map<String, String> jsonToModify = new HashMap<>(inputJson);
        jsonToModify.put("id", "123");
        return ResponseEntity.ok().body(jsonToModify);
    }

}
