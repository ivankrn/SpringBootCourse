package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.model.Bug;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<String> addIdToJson(@RequestBody String inputJson) throws JSONException {
        JSONObject jsonObject = new JSONObject(inputJson);
        jsonObject.put("id", 123);
        return ResponseEntity.ok().body(jsonObject.toString());
    }

}
