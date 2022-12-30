package src.main.java.view;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

    final private Scanner console = new Scanner(System.in);

    @Override
    public void print(String msg) {
        System.out.print(msg);
    }

    @Override
    public void println(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        return console.nextLine();
    }

    @Override
    public double readDouble(String prompt) {
        boolean invalidInput = true;
        double num = 0.0;

        while(invalidInput){
            try{
                String stringVal = this.readString(prompt);
                num = Double.parseDouble(stringVal);
                invalidInput = false;
            } catch (NumberFormatException e){
                this.print("Input Error. Please try again.");
            }
        }

        return num;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double result;

        do{
            result = this.readDouble(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public float readFloat(String prompt) {
        boolean invalidInput = true;
        float num = 0.0f;

        while(invalidInput){
            try{
                String stringVal = this.readString(prompt);
                num = Float.parseFloat(stringVal);
                invalidInput = false;
            } catch (NumberFormatException e){
                this.print("Input Error. Please try again.");
            }
        }

        return num;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;

        do{
            result = this.readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;

        while(invalidInput){
            try{
                String stringVal = this.readString(prompt);
                num = Integer.parseInt(stringVal);
                invalidInput = false;
            } catch (NumberFormatException e){
                this.print("Input Error. Please try again.");
            }
        }

        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;

        do{
            result = this.readInt(prompt);
        } while (result < min || result > max);

        return result;

    }

    @Override
    public long readLong(String prompt) {
        boolean invalidInput = true;
        long num = 0;

        while(invalidInput){
            try{
                String stringVal = this.readString(prompt);
                num = Long.parseLong(stringVal);
                invalidInput = false;
            } catch (NumberFormatException e){
                this.print("Input Error. Please try again.");
            }
        }

        return num;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;

        do{
            result = this.readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

}
