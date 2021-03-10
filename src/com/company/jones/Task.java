package com.company.jones;

public class Task {
    private String title;
    private int priority;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task(AdIn input) {
        this.title=input.promptString("whta th etitle for this task?");
        this.priority=input.promptInt("what proirty level it gon be?", 5);
        this.description=input.promptString("what tis the secriptuoij for this task?");
    }

    @Override
    public String toString() {
        return this.getTitle()+": \n "+this.getDescription()+"\nPriotity level: "+this.getPriority();
    }
}
