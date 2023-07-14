import java.util.ArrayList;
import java.util.Random;

public class Locker
{
    private final int number;
    private final int[][] comboArray = new int[5][3];
    private int comboIndex = 0;
    private final ArrayList<String> contents = new ArrayList<>();

    public Locker(int number)
    {
        this.number = number;
        Random random = new Random();

        for (int i = 0; i < comboArray.length; i++)
        {
            comboArray[i][0] = random.nextInt(50);
            comboArray[i][1] = random.nextInt(10) + i * 10;
            comboArray[i][2] = random.nextInt(50);
        }
    }

    public String toString()
    {
        String numAndCombos = "";
        numAndCombos += "Locker: " + number + "\n";
        numAndCombos += "A: " + comboToString(0) + "\n";
        numAndCombos += "B: " + comboToString(1) + "\n";
        numAndCombos += "C: " + comboToString(2) + "\n";
        numAndCombos += "D: " + comboToString(3) + "\n";
        numAndCombos += "E: " + comboToString(4) + "\n";

        StringBuilder contentString = new StringBuilder(numAndCombos + "Contents: ");
        String output;
        for (int i = 0; i < contents.size() - 1; i++)
        {
            contentString.append(contents.get(i));
            contentString.append(", ");
        }
        if (!contents.isEmpty())
        {
            contentString.append(contents.get(contents.size() - 1));
            output = contentString.toString();
        }
        else
            output = "";

        return output;
    }

    public String getCombination()
    {
        return comboToString(comboIndex % 5);
    }

    public void nextCombination()
    {
        comboIndex++;
    }

    public void addItem(String item)
    {
        contents.add(item);
    }

    public void removeItem(String item)
    {
        for (int i = 0; i < contents.size(); i++)
        {
            if (contents.get(i).equals(item))
            {
                contents.remove(i);
                break;
            }
        }
    }

    public String getContents()
    {
        StringBuilder contentString = new StringBuilder();
        String output;
        for (int i = 0; i < contents.size() - 1; i++)
        {
            contentString.append(contents.get(i));
            contentString.append(", ");
        }
        if (!contents.isEmpty())
        {
            contentString.append(contents.get(contents.size() - 1));
            output = contentString.toString();
        }
        else
            output = "";

        return output;
    }

    private String comboToString(int row)
    {
        return comboArray[row][0] + "-" + comboArray[row][1] + "-" + comboArray[row][2];
    }
}
