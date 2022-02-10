package edu.uoc.pac4;

public class Task {
	
	private String name;
	private int workload;
	private TaskType type;
	
	public Task (String name, int workload, TaskType type) {
		this.name=name;
		setWorkload(workload);
		this.type=type;
	}

	public String getName() {
		return name;
	}
	
	public int getWorkload() {
		return workload;
	}
	
	public void setWorkload(int workload) {
		this.workload = workload;
	}
	
	public TaskType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "";
	}
}
