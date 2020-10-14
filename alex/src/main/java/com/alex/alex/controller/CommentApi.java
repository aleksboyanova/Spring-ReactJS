package com.alex.alex.controller;

import com.alex.alex.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentApi {

    @Autowired
    private List<Comment> comments;

    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok(this.comments);
    }

    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        if (this.comments.add(comment)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping(value = "/{index}")
    public ResponseEntity<?> updateComment(@RequestBody Comment comment, @PathVariable int index) {
        if (this.comments.size() > index && index >= 0) {
            Comment post = this.comments.get(index);
            post.setCreator(comment.getCreator());
            post.setBody(comment.getBody());
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping(value = "/{index}")
    public ResponseEntity<?> deleteComment(@PathVariable int index) {
        if (this.comments.size() > index && index >= 0) {
            this.comments.remove(index);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
