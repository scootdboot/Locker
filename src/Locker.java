import java.util.ArrayList;
import java.util.Random;

public class Locker
{
    // creating all the variables
    private final int number;
    private final int[] comboA = new int[3];
    private final int[] comboB = new int[3];
    private final int[] comboC = new int[3];
    private final int[] comboD = new int[3];
    private final int[] comboE = new int[3];
    private int comboIndex = 0;
    private final ArrayList<String> contents = new ArrayList<>();

    public Locker(int number)
    {
        this.number = number;

        // just goes through and generates all the codes
        Random random = new Random();
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
        // going through manually and displaying all of them since i created them into an integer array
        output += "A: " + comboA[0] + "-" + comboA[1] + "-" + comboA[2] + "\n";
        output += "B: " + comboB[0] + "-" + comboB[1] + "-" + comboB[2] + "\n";
        output += "C: " + comboC[0] + "-" + comboC[1] + "-" + comboC[2] + "\n";
        output += "D: " + comboD[0] + "-" + comboD[1] + "-" + comboD[2] + "\n";
        output += "E: " + comboE[0] + "-" + comboE[1] + "-" + comboE[2] + "\n";
        // looping through contents
        output += "Contents: ";
        for (int i = 0; i < contents.size() - 1; i++)
        {
            output += contents.get(i) + ", ";
        }
        // gets rid of one particular error that comes up in the test case when a locker has no contents
        if (contents.size() != 0)
            output += contents.get(contents.size() - 1);
        return output;
    }

    public String getCombination()
    {
        // switch determines which one to execute and selects a combination in the process (fun way to just use modulus rather than having to use an if statement to reset)
        switch (comboIndex % 5)
        {
            case (0) -> { return comboA[0] + "-" + comboA[1] + "-" + comboA[2]; }
            case (1) -> { return comboB[0] + "-" + comboB[1] + "-" + comboB[2]; }
            case (2) -> { return comboC[0] + "-" + comboC[1] + "-" + comboC[2]; }
            case (3) -> { return comboD[0] + "-" + comboD[1] + "-" + comboD[2]; }
            case (4) -> { return comboE[0] + "-" + comboE[1] + "-" + comboE[2]; }
        }
        return "what in the ever-loving-"; // fun way to get intellij to stop throwing a fit over potential lack of return (it will ALWAYS return something else or error out)
    }

    public void nextCombination()
    {
        // the switch above handles conversion to an actual combination
        comboIndex++;
    }

    public void addItem(String itemToAdd)
    {
        contents.add(itemToAdd);
    }

    public String getContents()
    {
        // exactly the same code as seen in toString()
        String output = "";
        for (int i = 0; i < contents.size() - 1; i++)
        {
            output += contents.get(i) + ", ";
        }
        if (contents.size() != 0)
            output += contents.get(contents.size() - 1);
        return output;
    }

    public void removeItem(String itemToRemove)
    {
        // loop through and find the first element that matches, break after that
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
