public class TerningSpiller
{

	//objekter

	private int poeng;
	private int terningkast;
	private final String navn;

	//etablere metoder for getSumPoeng(), kastTerningen()...

	java.util.Random terning = new java.util.Random();

	public TerningSpiller(String navn, int poeng)
	{
		this.navn = navn;
		this.poeng = poeng;
	}

	public TerningSpiller(String navn)
	{
		this.navn = navn;
		this.poeng = 0;
	}

	public int getSumPoeng()
	{
		return poeng;
	}

	public void kastTerningen()
	{
		int terningkast = terning.nextInt(6);
		if (terningkast == 1) {
			poeng = 0;
		} else {
			poeng += terningkast;
		}
	}

	public String toString()
	{
		return navn + " har " + poeng;
	}
}