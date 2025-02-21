package com.example.backend.dto.request;

public class ChildParentRequest {
    private ParentRequest parentRequest;
    private ChildRequest childRequest;


    public ChildParentRequest(){};
    
    public ChildParentRequest(ParentRequest parentRequest, ChildRequest childRequest) {
        this.parentRequest = parentRequest;
        this.childRequest = childRequest;
    }

    public ParentRequest getParentRequest() {
        return parentRequest;
    }

    public ChildRequest getChildRequest() {
        return childRequest;
    }

    public void setParentRequest(ParentRequest parentRequest) {
        this.parentRequest = parentRequest;
    }

    public void setChildRequest(ChildRequest childRequest) {
        this.childRequest = childRequest;
    }
}
