/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

/**
 *
 * @author lukas.oros
 */
public class Task {
    private int id;
    private String taskname;
    private String description;
    private String deadline;
    private Boolean is_finished;
    
    public Task(){
        
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setIs_finished(Boolean is_finished) {
        this.is_finished = is_finished;
    }
    
    
    
    public Task(int id,String Taskname, String Description, String Deadline, Boolean Finished)
    {
        this.id = id;
        this.taskname = Taskname;
        this.description = Description;
        this.deadline = Deadline;
        this.is_finished = Finished;
    }

    Task(int aInt, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getid(){
        return id;
    }
    
    public String getTaskname()
    {
        return taskname;
    }
    
    public String getDescription(){
        return description;
    }
    
    public String getDeadline(){
        return deadline;
    }
    
    public Boolean getFinished(){
        return is_finished;
    }
    
}
