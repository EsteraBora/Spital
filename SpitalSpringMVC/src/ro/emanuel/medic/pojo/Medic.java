package ro.emanuel.medic.pojo;

public class Medic {
	private int id;
	private String nume;
	private String specialitate;
	private int vechime;
	private int salar;

	public Medic() {
		super();
	}
	
	public Medic(int id, String nume, String specialitate, int vechime, int salar)
    {
		super();
		this.id = id;
		this.nume = nume;
		this.specialitate = specialitate;
		this.vechime = vechime;
		this.salar = salar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getSpecialitate() {
		return specialitate;
	}

	public void setSpecialitate(String specialitate) {
		this.specialitate = specialitate;
	}

	public int getVechime() {
		return vechime;
	}

	public void setVechime(int vechime) {
		this.vechime = vechime;
	}

	public int getSalar() {
		return salar;
	}

	public void setSalar(int salar) {
		this.salar = salar;
	}

}
