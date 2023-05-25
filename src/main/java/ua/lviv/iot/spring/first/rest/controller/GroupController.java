package ua.lviv.iot.spring.first.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.first.business.GroupService;
import ua.lviv.iot.spring.first.rest.model.Group;

import java.util.List;

@RequestMapping("/groups")
@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public Group createStudent(final @RequestBody Group group) {
        return groupService.createStudent(group);
    }

}
