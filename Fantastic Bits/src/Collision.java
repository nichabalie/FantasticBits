class Collision {
	public Entity entityA;
	public Entity entityB;
	public double t;
	
	public Collision(Entity entityA, Entity entityB, double t) {
		this.entityA = entityA;
		this.entityB = entityB;
		this.t = t;
	}
	
	public void printAll() {
		System.err.println("----------COLLISION-------------------");
		this.entityA.printAll();
		this.entityB.printAll();
		System.err.println("t="+t);
		System.err.println("--------------------------------------");
	}
	
	public void print() {
		System.err.println("Collision: " + entityA.getId() + " and " + entityB.getId() + " at " + t);
	}
}