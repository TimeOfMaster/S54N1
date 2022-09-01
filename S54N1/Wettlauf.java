import java.util.Random;

public class Wettlauf
{

    private static final int MAXIMUM_TIME = 20; // definition for largest possible time in seconds
    private static final int MINIMUM_TIME = 10; // definition for smallest possible time in seconds

    private Laeufer[] laeuferfeld;

    Wettlauf(int pLenght)
    {
        if(!startCondition(pLenght))
        {
            return;
        }

        anDenStart(pLenght);

        rennenLaufen();
    }

    public boolean startCondition(int pLenght)
    {
        if (pLenght < 2) 
        {
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("You need at least two Runners");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            return false;
        } 
        return true;
    }

    public void anDenStart(int pLenght)
    {
        this.laeuferfeld = new Laeufer[pLenght];

        for (int i = 0; i < pLenght; i++)
        {
            this.laeuferfeld[i] = new Laeufer();
            this.laeuferfeld[i].setName(genName());
            this.laeuferfeld[i].setZeit(0);
            this.laeuferfeld[i].setQualifiziert(true);
            // this.laeuferfeld[i] = new Laeufer("MatheMann", 0, true);
        }
    }

    public int averageTime()
    {
        int averageTime = 0;
        int tempTime = 0;

        for (int i = 0; i < laeuferfeld.length; i++)
        {
            tempTime += laeuferfeld[i].getZeit();
        }

        averageTime = tempTime / laeuferfeld.length;

        return averageTime;
    }

    public int maxTimeIndex()
    {
        int tempTime = MINIMUM_TIME;
        int maxTimeIndex = 0;

        for (int i = 0; i < laeuferfeld.length; i++)
        {
            if(tempTime < laeuferfeld[i].getZeit())
            {
                maxTimeIndex = i;
                tempTime = laeuferfeld[i].getZeit();
            } 
        }

        return maxTimeIndex;
    }
    
    public int minTimeIndex()
    {
    
        int tempTime = MAXIMUM_TIME;
        int minTimeIndex = 0;

        for (int i = 0; i < laeuferfeld.length; i++)
        {
            if(tempTime > laeuferfeld[i].getZeit())
            {
                minTimeIndex = i;
                tempTime = laeuferfeld[i].getZeit();
            } 
        }

        return minTimeIndex;
    }

    public String genName()
    {
        String name = "";
        String names[] = {"John", "Alexander", "Alex", "Max", "Felix", "Elias", "Elise", "Benjamin",
                          "Ben", "Brandon", "Eric", "Erik", "Mark", "Markus", "Charles", "Thomas", "Jakob", "Jacob", "Finn", "Fynn"};

        Random random = new Random();
        int index = random.nextInt(names.length);

        name = names[index];

        return name;
    }

    public int zeitMessen()
    {
        return  getRandomNumber(MINIMUM_TIME, MAXIMUM_TIME);
    }

    public void rennenLaufen()
    {
        int zeit = 0;
        int lenght = 8;
        
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < lenght; i++)
        {
            zeit = zeitMessen();

            laeuferfeld[i].setZeit(zeit);

            System.out.println(laeuferfeld[i].getName());
            System.out.println(zeit);
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }

        Laeufer maxLaeufer = laeuferfeld[maxTimeIndex()];
        Laeufer minLaeufer = laeuferfeld[minTimeIndex()];

        // AverageTime
        System.out.println("");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Average Time:" + " " + averageTime());
    
        // MaxTime
        System.out.println("");
        System.out.println("Max Time:" + " " + maxLaeufer.getZeit() + " " + "by" + " " + maxLaeufer.getName());

        // MinTime
        System.out.println("");
        System.out.println("Min Time:" + " " + minLaeufer.getZeit() + " " + "by" + " " + minLaeufer.getName());
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");                

    }

    public int getRandomNumber(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
}