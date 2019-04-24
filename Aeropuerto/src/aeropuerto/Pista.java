package aeropuerto;

public class Pista {
	private boolean isAvailable;
	private Semaforo semaphore;
	
	public Pista() {
		this.isAvailable = true;
		this.semaphore = new Semaforo(1);
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Semaforo getSemaphore() {
		return semaphore;
	}
	public void setSemaphore(Semaforo semaphore) {
		this.semaphore = semaphore;
	}
	
	
}
