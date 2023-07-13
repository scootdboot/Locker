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

        comboA[0] = random.nextInt(50);
        comboA[1] = random.nextInt(10);
        comboA[2] = random.nextInt(50);

        comboB[0] = random.nextInt(50);
        comboB[1] = random.nextInt(10) + 10;
        comboB[2] = random.nextInt(50);

        comboC[0] = random.nextInt(50);
        comboC[1] = random.nextInt(10) + 20;
        comboC[2] = random.nextInt(50);

        comboD[0] = random.nextInt(50);
        comboD[1] = random.nextInt(10) + 30;
        comboD[2] = random.nextInt(50);

        comboE[0] = random.nextInt(50);
        comboE[1] = random.nextInt(10) + 40;
        comboE[2] = random.nextInt(50);
    }

    public String toString()
    {
        String output = "";
        output += "Locker: " + number + "\n";
        output += "A: " + comboA[0] + "-" + comboA[1] + "-" + comboA[2] + "\n";
        output += "B: " + comboB[0] + "-" + comboB[1] + "-" + comboB[2] + "\n";
        output += "C: " + comboC[0] + "-" + comboC[1] + "-" + comboC[2] + "\n";
        output += "D: " + comboD[0] + "-" + comboD[1] + "-" + comboD[2] + "\n";
        output += "E: " + comboE[0] + "-" + comboE[1] + "-" + comboE[2] + "\n";
        output += "Contents: ";
        for (String item : contents)
        {
            output += item + ", ";
        }
        output = output.substring(0, output.length() - 3);
        return output;
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
        return "what in the everloving-";
    }

    public void nextCombination()
    {
        comboIndex++;
    }

    public void addItem(String itemToAdd)
    {
        contents.add(itemToAdd);
    }

    public String getContents()
    {
        String output = "";
        for (String item : contents)
        {
            output += item + ", ";
        }
        output += "\n";
        return output;
    }

    public void removeItem(String itemToRemove)
    {
        for (int i = 0; i < contents.size(); i++)
        {
            if (contents.get(i).equals(itemToRemove))
            {
                contents.remove(i);
                break;
            }
        }
    }
}
