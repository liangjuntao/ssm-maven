package example.queue;

public class Task implements Comparable<Task>{
	private int id;
	private String name;
	
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//
	@Override
	public int compareTo(Task o) {
		return this.id > o.id ? 1: (this.id < o.id ? -1:0); 
	}
	
	
}
