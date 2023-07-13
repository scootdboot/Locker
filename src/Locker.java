import java.util.ArrayList;
import java.util.Random;

public class Locker
{
    private int number;
    private int[] comboA = new int[3];
    private int[] comboB = new int[3];
    private int[] comboC = new int[3];
    private int[] comboD = new int[3];
    private int[] comboE = new int[3];
    private int comboIndex = 0;
    private ArrayList<String> contents = new ArrayList<String>();
    private Random random = new Random();

    public Locker(int number)
    {
        this.number = number;

        this.comboA[0] = random.nextInt(50);
        this.comboA[1] = random.nextInt(10);
        this.comboA[2] = random.nextInt(50);

        this.comboB[0] = random.nextInt(50);
        this.comboB[1] = random.nextInt(10) + 10;
        this.comboB[2] = random.nextInt(50);

        this.comboC[0] = random.nextInt(50);
        this.comboC[1] = random.nextInt(10) + 20;
        this.comboC[2] = random.nextInt(50);

        this.comboD[0] = random.nextInt(50);
        this.comboD[1] = random.nextInt(10) + 30;
        this.comboD[2] = random.nextInt(50);

        this.comboE[0] = random.nextInt(50);
        this.comboE[1] = random.nextInt(10) + 40;
        this.comboE[2] = random.nextInt(50);
    }

    public String getCombination()
    {
        switch (comboIndex % 5)
        {
            case (0) -> { return comboA[0] + "-" + comboA[1] + "-" + comboA[2]; }
            case (1) -> { return comboB[0] + "-" + comboB[1] + "-" + comboB[2]; }
            case (2) -> { return comboC[0] + "-" + comboC[1] + "-" + comboC[2]; }
            case (3) -> { return comboD[0] + "-" + comboD[1] + "-" + comboD[2]; }
            case (4) -> { return comboE[0] + "-" + comboE[1] + "-" + comboE[2]; }
        }
    }
}
