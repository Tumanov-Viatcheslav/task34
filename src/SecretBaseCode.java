import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecretBaseCode {

    private static InputData read() {
        InputData data = new InputData();
        try (BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            data.k = Integer.parseInt(input.readLine().split(" ")[1]);
            data.s = input.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    private static boolean check(int baseCodeLength, String line) {
        if (line.length() < baseCodeLength)
            return false;
        String checkLine;
        for (int i = 0; i < line.length() - baseCodeLength; i++) {
            checkLine = line.substring(i, i + baseCodeLength);
            if (line.indexOf(checkLine, i + 1) != -1)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        InputData inputData = read();
        boolean contains = check(inputData.k, inputData.s);
        if (contains)
            System.out.println("YES");
        else System.out.println("NO");
    }

    static class InputData {
        int k;
        String s;
    }
}