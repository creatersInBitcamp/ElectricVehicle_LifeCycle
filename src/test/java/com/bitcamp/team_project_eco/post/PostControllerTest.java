package com.bitcamp.team_project_eco.post;

import antlr.ASTNULLType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PostControllerTest {

    @Test
    void getAllPost() {
        public List<Post> getAllPost(){
            ASTNULLType service;
            return (List<Post>) service.findAll();
        }
    }
}