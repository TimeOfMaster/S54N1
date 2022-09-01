public class Laeufer
{
    private String name = "";
    private int zeit = 0;
    private boolean qualifiziert = false;

    public Laeufer()
    {
        this.name = "";
        this.zeit = 0;
        this.qualifiziert = false;
    }
/*/
    public Laeufer(String sName, int iZeit, boolean bQualifiziert)
    {
        this.name = sName;
        this.zeit = iZeit;
        this.qualifiziert = bQualifiziert;
    }
*/
    public String getName()
    {
        return name;
    }	

    public int getZeit()
    {
        return zeit;
    }

    public boolean isQualifiziert()
    {
        return qualifiziert;
    }   

    public void setName(String sName)
    {
        this.name = sName;
    }

    public void setZeit(int iZeit)
    {
        this.zeit = iZeit;
    }

    public void setQualifiziert(boolean bQualifiziert)
    {
        this.qualifiziert = bQualifiziert;
    }
}