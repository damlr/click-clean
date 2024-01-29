package clickClean;

public class Mission {
	
	private int surfaceBien;       
	private String rueAdresse;
	private float remuneration;
	private int numAdresse;
	private String typePrestation;
	private String instructionSupp;
	private String statutMisssion;
	
	
	public Mission(int surfaceBien, String rueAdresse, float remuneration, int numAdresse, String typePrestation,
			String instructionSupp, String statutMisssion) {
		super();
		this.surfaceBien = surfaceBien;
		this.rueAdresse = rueAdresse;
		this.remuneration = remuneration;
		this.numAdresse = numAdresse;
		this.typePrestation = typePrestation;
		this.instructionSupp = instructionSupp;
		this.statutMisssion = statutMisssion;
	}


	public String getInstructionSupp() {
		return instructionSupp;
	}
	public void setInstructionSupp(String instructionSupp) {
		this.instructionSupp = instructionSupp;
	}

	public String getStatutMisssion() {
		return statutMisssion;
	}
	public void setStatutMisssion(String statutMisssion) {
		this.statutMisssion = statutMisssion;
	}
	
	public int getSurfaceBien() {
		return surfaceBien;
	}
	
	public String getRueAdresse() {
		return rueAdresse;
	}
	
	public float getRemuneration() {
		return remuneration;
	}
	
	public int getNumAdresse() {
		return numAdresse;
	}
	
	public String getTypePrestation() {
		return typePrestation;
	}
	
	/**
	 * Méthode calcul de la zone d'action par rapport à l'adresse
	 */
	
	
}
